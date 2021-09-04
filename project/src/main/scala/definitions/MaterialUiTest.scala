package definitions

import common.{Libs, TestLibs}
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._
import scoverage.ScoverageKeys.coverageExcludedPackages

object MaterialUiTest extends ScalaJsModule {

  override val id = "scommons-material-ui-test"

  override val base: File = file("test")

  override def definition: Project = super.definition
    .settings(
      description := "Scala.js material-ui testing utilities and mocks",

      coverageExcludedPackages := "scommons.materialui.test.raw",

      npmDevDependencies in Compile ++= Seq(
        "module-alias" -> "2.2.2"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    MaterialUiCore.definition
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Seq(
    ("scommons-react", "scommons-react-core", None),
    ("scommons-react", "scommons-react-test", None),
    ("scommons-nodejs", "scommons-nodejs-test", None)
  )

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Seq(
    Libs.scommonsReactCore.value,
    TestLibs.scommonsReactTest.value,
    TestLibs.scommonsNodejsTest.value
  ))

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
