package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react.ReactClass

package object materialui {
  
  lazy val Icons: raw.IconsNative = raw.IconsNative

  implicit class MaterialUiVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val Button: ReactClassElementSpec = elements(raw.MaterialUiNative.Button)
    lazy val Icon: ReactClassElementSpec = elements(raw.MaterialUiNative.Icon)
    lazy val IconButton: ReactClassElementSpec = elements(raw.MaterialUiNative.IconButton)
  }

  object MaterialUiVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ComponentAttributeSpec(name: String) extends AttributeSpec {
      def :=(comp: ReactClass): Attribute[ReactClass] = Attribute(name, comp, AS_IS)
      def :=(comp: String): Attribute[String] = Attribute(name, comp, AS_IS)
    }
  }

  implicit class MaterialUiVirtualDOMAttributes(attributes: VirtualDOMAttributes)
    extends Button.ButtonAttributes {
    
    import MaterialUiVirtualDOMAttributes._

    lazy val color = StringAttributeSpec("color")
    lazy val component = ComponentAttributeSpec("component")
    lazy val fontSize = StringAttributeSpec("fontSize")
    lazy val muSize = StringAttributeSpec("size")
  }
}
