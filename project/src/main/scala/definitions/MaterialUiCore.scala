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

      npmDependencies in Compile ++= Seq(
        "@material-ui/core" -> "^4.12.3"
      ),

      npmDevDependencies in Compile ++= Seq(
        "babel-loader" -> "8.0.5",
        "@babel/core" -> "7.4.0",
        "@babel/preset-env" -> "7.4.2",

        "css-loader" -> "2.1.1",
        "mini-css-extract-plugin" -> "0.12.0",
        "resolve-url-loader" -> "3.1.2",
        "url-loader" -> "4.1.1",
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
