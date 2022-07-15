import definitions._
import scommons.sbtplugin.project.CommonModule
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

lazy val `scommons-material-ui` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(MaterialUiModule.settings: _*)
  .settings(
    publish / skip := true,
    publish := ((): Unit),
    publishLocal := ((): Unit),
    publishM2 := ((): Unit)
  )
  .settings(
    ideExcludedDirectories += baseDirectory.value / "docs" / "_site"
  )
  .aggregate(
    `scommons-material-ui-codegen`,
    `scommons-material-ui-core`,
    `scommons-material-ui-test`,
    `scommons-material-ui-showcase`
  )

lazy val `scommons-material-ui-codegen` = MaterialUiCodeGen.definition
lazy val `scommons-material-ui-core` = MaterialUiCore.definition
lazy val `scommons-material-ui-test` = MaterialUiTest.definition
lazy val `scommons-material-ui-showcase` = MaterialUiShowcase.definition
