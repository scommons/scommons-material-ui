package scommons.materialui.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

@js.native
@JSImport("@material-ui/core/colors", JSImport.Default)
object ColorsNative extends ColorsNative

@js.native
trait ColorsNative extends js.Object {

  val amber: Color = js.native
  val blue: Color = js.native
  val blueGrey: Color = js.native
  val brown: Color = js.native
  val common: CommonColor = js.native
  val cyan: Color = js.native
  val deepOrange: Color = js.native
  val deepPurple: Color = js.native
  val green: Color = js.native
  val grey: Color = js.native
  val indigo: Color = js.native
  val lightBlue: Color = js.native
  val lightGreen: Color = js.native
  val lime: Color = js.native
  val orange: Color = js.native
  val pink: Color = js.native
  val purple: Color = js.native
  val red: Color = js.native
  val teal: Color = js.native
  val yellow: Color = js.native
}

@js.native
trait Color extends js.Object {
  
  val `50`: String = js.native
  val `100`: String = js.native
  val `200`: String = js.native
  val `300`: String = js.native
  val `400`: String = js.native
  val `500`: String = js.native
  val `600`: String = js.native
  val `700`: String = js.native
  val `800`: String = js.native
  val `900`: String = js.native

  val A100: String = js.native
  val A200: String = js.native
  val A400: String = js.native
  val A700: String = js.native
}

@js.native
trait CommonColor extends js.Object {

  val black: String = js.native
  val white: String = js.native
}
