package definitions

import sbt.Keys._
import sbt._
import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._
import scommons.sbtplugin.project.CommonNodeJsModule
import scoverage.ScoverageKeys.coverageExcludedPackages

object MaterialUiCodeGen extends MaterialUiModule with CommonNodeJsModule {

  override val id = "scommons-material-ui-codegen"

  override val base: File = file("codegen")

  override def definition: Project = super.definition
    .settings(
      publish / skip := true,
      publish := ((): Unit),
      publishLocal := ((): Unit),
      publishM2 := ((): Unit),

      coverageExcludedPackages :=
        "scommons.doctrine.raw" +
          ";scommons.reactdocgen.raw",

      Compile / npmDependencies ++= Seq(
        "doctrine" -> "^3.0.0",
        "react-docgen" -> "^5.4.0"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil
}
