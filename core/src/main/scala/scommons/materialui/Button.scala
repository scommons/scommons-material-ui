package scommons.materialui

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMAttributes
import io.github.shogowada.statictags._
import scommons.react.ReactElement

/** @see https://material-ui.com/api/button/
  */
object Button {

  trait ButtonAttributes {

    import ButtonAttributes._

    lazy val disableElevation = BooleanAttributeSpec("disableElevation")
    lazy val disableRipple = BooleanAttributeSpec("disableRipple")
    lazy val endIcon = ReactElementAttributeSpec("endIcon")
    lazy val fullWidth = BooleanAttributeSpec("fullWidth")
    lazy val startIcon = ReactElementAttributeSpec("startIcon")
    lazy val variant = StringAttributeSpec("variant")
  }

  object ButtonAttributes {

    import VirtualDOMAttributes.Type._

    case class ReactElementAttributeSpec(name: String) extends AttributeSpec {
      def :=(elem: ReactElement): Attribute[ReactElement] = Attribute(name, elem, AS_IS)
    }
  }
}
