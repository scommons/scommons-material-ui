package definitions

import common.Libs
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages

object MaterialUiCore extends ScalaJsModule {

  override val id = "scommons-material-ui-core"

  override val base: File = file("core")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js facades for material-ui core components and APIs",

      coverageExcludedPackages := "scommons.materialui.raw",

      Compile / npmDependencies ++= Seq(
        "@material-ui/core" -> "^4.12.3",
        "@material-ui/icons" -> "^4.11.2"
      ),

      Compile / npmDevDependencies ++= Seq(
        "webpack-node-externals" -> "2.5.2",
        "webpack-merge" -> "4.2.1"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil

  override def superRepoProjectsDependencies: Seq[(String, String, Option[String])] = {
    super.superRepoProjectsDependencies ++ Seq(
      ("scommons-react", "scommons-react-dom", None)
    )
  }

  override def runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting {
    super.runtimeDependencies.value ++ Seq(
      Libs.scommonsReactDom.value
    )
  }
}
