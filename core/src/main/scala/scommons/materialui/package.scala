package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react.ReactClass

package object materialui {
  
  lazy val colors: raw.ColorsNative = raw.ColorsNative
  lazy val icons: raw.IconsNative = raw.IconsNative

  implicit class MaterialUiVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val Button: ReactClassElementSpec = elements(raw.MaterialUiNative.Button)
    lazy val ButtonBase: ReactClassElementSpec = elements(raw.MaterialUiNative.ButtonBase)
    lazy val Icon: ReactClassElementSpec = elements(raw.MaterialUiNative.Icon)
    lazy val IconButton: ReactClassElementSpec = elements(raw.MaterialUiNative.IconButton)
    lazy val Typography: ReactClassElementSpec = elements(raw.MaterialUiNative.Typography)
  }

  object MaterialUiVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ComponentAttributeSpec(name: String) extends AttributeSpec {
      def :=(comp: ReactClass): Attribute[ReactClass] = Attribute(name, comp, AS_IS)
      def :=(comp: String): Attribute[String] = Attribute(name, comp, AS_IS)
    }
  }

  implicit class MaterialUiVirtualDOMAttributes(attributes: VirtualDOMAttributes)
    extends Button.ButtonAttributes
      with ButtonBase.ButtonBaseAttributes {
    
    import MaterialUiVirtualDOMAttributes._

    lazy val color = StringAttributeSpec("color")
    lazy val component = ComponentAttributeSpec("component")
    lazy val fontSize = StringAttributeSpec("fontSize")
    lazy val muiSize = StringAttributeSpec("size")
    lazy val variant = StringAttributeSpec("variant")
  }
}
