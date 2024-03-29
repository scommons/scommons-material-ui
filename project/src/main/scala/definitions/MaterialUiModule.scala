package definitions

import common.Libs
import org.scoverage.coveralls.Imports.CoverallsKeys._
import sbt.Keys._
import sbt._
import scommons.sbtplugin.project.CommonModule
import xerial.sbt.Sonatype.autoImport._

trait MaterialUiModule extends CommonModule {

  val scommonsNodejsVersion: String = Libs.scommonsNodejsVersion
  
  override val repoName = "scommons-material-ui"

  override def definition: Project = {
    super.definition
      .settings(MaterialUiModule.settings: _*)
  }
}

object MaterialUiModule {

  val settings: Seq[Setting[_]] = Seq(
    organization := "org.scommons.material-ui",
    
    coverallsService := GitHubActionsCI.jobId.map(_ => GitHubActionsCI),

    //
    // publish/release related settings:
    //
    sonatypeProfileName := "org.scommons",
    publishMavenStyle := true,
    Test / publishArtifact := false,
    publishTo := sonatypePublishToBundle.value,
    pomExtra := {
      <url>https://github.com/scommons/scommons-material-ui</url>
        <licenses>
          <license>
            <name>The MIT License</name>
            <url>https://opensource.org/licenses/MIT</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>git@github.com:scommons/scommons-material-ui.git</url>
          <connection>scm:git@github.com:scommons/scommons-material-ui.git</connection>
        </scm>
        <developers>
          <developer>
            <id>viktorp</id>
            <name>Viktor Podzigun</name>
            <url>https://github.com/viktor-podzigun</url>
          </developer>
        </developers>
    },
    pomIncludeRepository := {
      _ => false
    }
  )
}
