package scommons.materialui

import scala.scalajs.js

package object styles {

  type NativeTheme = raw.ThemeNative with js.Dynamic
  type Theme = raw.Theme
  type Styles = raw.Styles

  @inline
  def styleOf(style: js.Dynamic): String = {
    style.asInstanceOf[String]
  }
  
  def makeStyles(f: js.Function1[NativeTheme, Styles]): js.Function0[js.Dynamic] = {
    raw.StylesNative.makeStyles(f)
  }
}
