package scommons.materialui.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import scala.scalajs.js.|

@js.native
@JSImport("@material-ui/core/styles", JSImport.Default)
object StylesNative extends js.Object {
  
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
