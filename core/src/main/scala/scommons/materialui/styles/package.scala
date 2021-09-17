package scommons.materialui

import io.github.shogowada.scalajs.reactjs.VirtualDOM.VirtualDOMElements.ReactClassElementSpec
import io.github.shogowada.scalajs.reactjs.VirtualDOM._
import io.github.shogowada.statictags._
import scommons.react.ReactClass

import scala.scalajs.js

package object styles {

  type NativeTheme = raw.ThemeNative with js.Dynamic
  type Theme = raw.Theme
  type Styles = raw.Styles
  type WithStylesOptions = raw.WithStylesOptions

  implicit class MaterialUiStylesVirtualDOMElements(elements: VirtualDOMElements) {
    lazy val ThemeProvider: ReactClassElementSpec = elements(raw.StylesNative.ThemeProvider)
  }

  object MaterialUiStylesVirtualDOMAttributes {

    import VirtualDOMAttributes.Type._

    case class ThemeAttributeSpec(name: String) extends AttributeSpec {
      def :=(theme: Theme): Attribute[Theme] = Attribute(name, theme, AS_IS)
      def :=(f: js.Function1[NativeTheme, Theme]): Attribute[js.Function1[NativeTheme, Theme]] =
        Attribute(name, f, AS_IS)
    }
  }

  implicit class MaterialUiStylesVirtualDOMAttributes(attributes: VirtualDOMAttributes) {

    import MaterialUiStylesVirtualDOMAttributes._

    lazy val theme = ThemeAttributeSpec("theme")
  }

  @inline
  def styleOf(style: js.Dynamic): String =
    style.asInstanceOf[String]
  
  @inline
  def createTheme(options: js.Object, args: js.Object*): raw.ThemeNative =
    raw.StylesNative.createTheme(options, args: _*)

  @inline
  def makeStyles(f: js.Function1[NativeTheme, Styles]): js.Function0[js.Dynamic] =
    raw.StylesNative.makeStyles(f)

  @inline
  def withStyles(styles: Styles): js.Function1[ReactClass, ReactClass] =
    raw.StylesNative.withStyles(styles)

  @inline
  def withStyles(styles: Styles, options: WithStylesOptions): js.Function1[ReactClass, ReactClass] =
    raw.StylesNative.withStyles(styles, options)

  @inline
  def withStyles(styles: NativeTheme => Styles): js.Function1[ReactClass, ReactClass] =
    raw.StylesNative.withStyles(styles: js.Function1[NativeTheme, Styles])

  @inline
  def withStyles(styles: NativeTheme => Styles, options: WithStylesOptions): js.Function1[ReactClass, ReactClass] =
    raw.StylesNative.withStyles(styles: js.Function1[NativeTheme, Styles], options)
}
