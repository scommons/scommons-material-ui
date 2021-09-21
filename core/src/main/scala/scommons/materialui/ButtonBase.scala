package scommons.materialui

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMAttributes
import io.github.shogowada.statictags._
import scommons.materialui.styles.Styles

/** @see https://material-ui.com/api/button-base/
  */
object ButtonBase {

  trait ButtonBaseAttributes {

    import ButtonBaseAttributes._

    lazy val focusRipple = BooleanAttributeSpec("focusRipple")
    lazy val focusVisibleClassName = StringAttributeSpec("focusVisibleClassName")
    lazy val muiStyle = StyleAttributeSpec("style")
  }

  object ButtonBaseAttributes {

    import VirtualDOMAttributes.Type._

    case class StyleAttributeSpec(name: String) extends AttributeSpec {
      def :=[T <: Styles](style: T): Attribute[T] = Attribute(name, style, AS_IS)
    }
  }
}
