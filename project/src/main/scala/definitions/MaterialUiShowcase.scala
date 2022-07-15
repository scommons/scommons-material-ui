package definitions

import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._
import scommons.sbtplugin.ScommonsPlugin.autoImport._
import scoverage.ScoverageKeys._

object MaterialUiShowcase extends ScalaJsModule {

  override val id = "scommons-material-ui-showcase"

  override val base: File = file("showcase")

  override def definition: Project = super.definition
    .settings(
      publish / skip := true,
      publish := ((): Unit),
      publishLocal := ((): Unit),
      publishM2 := ((): Unit),

      coverageExcludedPackages := "scommons.materialui.showcase.ShowcaseMain",

      scalaJSUseMainModuleInitializer := true,
      webpackBundlingMode := BundlingMode.LibraryOnly(),

      scommonsResourcesArtifacts ++= Seq(
        "org.scommons.material-ui" % "scommons-material-ui-test" % "*"
      ),
      // we substitute references to material-ui modules with our custom mocks during test
      scommonsNodeJsTestLibs := Seq("scommons.materialui.aliases.js"),
      scommonsRequireWebpackInTest := true,
      Test / webpackConfigFile := Some(baseDirectory.value / "test.webpack.config.js"),
      
      //dev
      fastOptJS / webpackConfigFile := Some(baseDirectory.value / "client.webpack.config.js"),
      //production
      fullOptJS / webpackConfigFile := Some(baseDirectory.value / "client.webpack.config.js")
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Seq(
    MaterialUiCore.definition,
    MaterialUiTest.definition % "test"
  )

  override val superRepoProjectsDependencies: Seq[(String, String, Option[String])] = Nil

  override val runtimeDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)

  override val testDependencies: Def.Initialize[Seq[ModuleID]] = Def.setting(Nil)
}
