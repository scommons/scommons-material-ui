package definitions

import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

import scalajsbundler.sbtplugin.ScalaJSBundlerPlugin.autoImport._

object MaterialUiCodeGen extends NodeJsModule {

  override val id = "scommons-material-ui-codegen"

  override val base: File = file("codegen")

  override def definition: Project = super.definition
    .settings(
      coverageExcludedPackages :=
        "scommons.doctrine.raw" +
          ";scommons.reactdocgen.raw",

      npmDependencies in Compile ++= Seq(
        "doctrine" -> "^3.0.0",
        "react-docgen" -> "^5.4.0"
      )
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil
}
