package scommons

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._

package object materialui {

  implicit class MaterialUiVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val Button: ReactClassElementSpec = elements(raw.MaterialUiNative.Button)
  }

  implicit class MaterialUiVirtualDOMAttributes(attributes: VirtualDOMAttributes)
    extends Button.ButtonAttributes {

    lazy val color = StringAttributeSpec("color")
    lazy val muSize = StringAttributeSpec("size")
  }
}
