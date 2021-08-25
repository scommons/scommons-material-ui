import definitions._
import scommons.sbtplugin.project.CommonModule
import scommons.sbtplugin.project.CommonModule.ideExcludedDirectories

lazy val `scommons-material-ui` = (project in file("."))
  .settings(CommonModule.settings: _*)
  .settings(MaterialUiModule.settings: _*)
  .settings(
    skip in publish := true,
    publish := ((): Unit),
    publishLocal := ((): Unit),
    publishM2 := ((): Unit)
  )
  .settings(
    ideExcludedDirectories += baseDirectory.value / "docs" / "_site"
  )
  .aggregate(
    `scommons-material-ui-codegen`
  )

lazy val `scommons-material-ui-codegen` = MaterialUiCodeGen.definition
