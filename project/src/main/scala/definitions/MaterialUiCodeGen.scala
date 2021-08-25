package definitions

import sbt._
import scoverage.ScoverageKeys.coverageExcludedPackages

object MaterialUiCodeGen extends NodeJsModule {

  override val id = "scommons-material-ui-codegen"

  override val base: File = file("codegen")

  override def definition: Project = super.definition
    .settings(
      coverageExcludedPackages := "scommons.materialui.codegen.raw"
    )

  override val internalDependencies: Seq[ClasspathDep[ProjectReference]] = Nil
}
