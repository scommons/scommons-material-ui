package scommons.materialui

import io.github.shogowada.statictags._

/** @see https://material-ui.com/api/button/
  */
object Button {

  trait ButtonAttributes {

    lazy val variant = StringAttributeSpec("variant")
    lazy val disableElevation = BooleanAttributeSpec("disableElevation")
  }

}
