package scommons.materialui.raw

import scommons.react.ReactClass

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("@material-ui/core/styles", JSImport.Default)
object StylesNative extends js.Object {

  val MuiThemeProvider: ReactClass = js.native
  val ThemeProvider: ReactClass = js.native

  def createTheme(options: js.Object, args: js.Object*): ThemeNative = js.native
  
  def withStyles(styles: Styles | js.Function1[ThemeNative with js.Dynamic, Styles],
                 options: js.UndefOr[WithStylesOptions] = js.undefined
                ): js.Function1[ReactClass, ReactClass] = js.native
  
  def createStyles(styles: Styles): Styles = js.native
  
  def makeStyles(callback: js.Function): js.Function0[js.Dynamic] = js.native
}

@js.native
trait ThemeNative extends Theme {
  
  def spacing(idx: Int,
              arg2: js.UndefOr[Int | String] = js.undefined,
              arg3: js.UndefOr[Int | String] = js.undefined,
              arg4: js.UndefOr[Int | String] = js.undefined
             ): Int | String = js.native
}

trait Theme extends js.Object

trait Styles extends js.Object

trait WithStylesOptions extends js.Object {
  
  val defaultTheme: js.UndefOr[Theme] = js.undefined
  val withTheme: js.UndefOr[Boolean] = js.undefined
  val name: js.UndefOr[String] = js.undefined
  val flip: js.UndefOr[Boolean] = js.undefined
}
