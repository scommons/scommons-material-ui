package common

import org.portablescala.sbtplatformdeps.PlatformDepsPlugin.autoImport._
import sbt._
import scommons.sbtplugin.project.CommonLibs

object Libs extends CommonLibs {

  val scommonsNodejsVersion = "0.6.0"
  val scommonsReactVersion = "0.6.0"

  lazy val scommonsNodejsCore = Def.setting("org.scommons.nodejs" %%% "scommons-nodejs-core" % scommonsNodejsVersion)
  lazy val scommonsReactCore = Def.setting("org.scommons.react" %%% "scommons-react-core" % scommonsReactVersion)
  lazy val scommonsReactDom = Def.setting("org.scommons.react" %%% "scommons-react-dom" % scommonsReactVersion)
}
