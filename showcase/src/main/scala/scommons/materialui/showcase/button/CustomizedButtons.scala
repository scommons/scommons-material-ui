package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.colors.{green, purple}
import scommons.materialui.styles._
import scommons.react._

import scala.scalajs.js

object CustomizedButtons extends FunctionComponent[Unit] {
  
  private[button] val BootstrapButton = withStyles({
    val s = new Styles {
      val root = new Styles {
        val boxShadow = "none"
        val textTransform = "none"
        val fontSize = 16
        val padding = "6px 12px"
        val border = "1px solid"
        val lineHeight = 1.5
        val backgroundColor = "#0063cc"
        val borderColor = "#0063cc"
        val fontFamily = js.Array(
          "-apple-system",
          "BlinkMacSystemFont",
          """"Segoe UI"""",
          "Roboto",
          """"Helvetica Neue"""",
          "Arial",
          "sans-serif",
          """"Apple Color Emoji"""",
          """"Segoe UI Emoji"""",
          """"Segoe UI Symbol""""
        ).join(",")
        val `&:hover` = new Styles {
          val backgroundColor = "#0069d9"
          val borderColor = "#0062cc"
          val boxShadow = "none"
        }
        val `&:active` = new Styles {
          val boxShadow = "none"
          val backgroundColor = "#0062cc"
          val borderColor = "#005cbf"
        }
        val `&:focus` = new Styles {
          val boxShadow = "0 0 0 0.2rem rgba(0,123,255,.5)"
        }
      }
    }
    s
  })(<.Button.reactClass)
  
  private[button] val ColorButton = withStyles(theme => {
    val s = new Styles {
      val root = new Styles {
        val color = theme.palette.getContrastText(purple.`500`)
        val backgroundColor = purple.`500`
        val `&:hover` = new Styles {
          val backgroundColor = purple.`700`
        }
      }
    }
    s
  })(<.Button.reactClass)
  
  private[button] val useStyles = makeStyles(theme => {
    val s = new Styles {
      val margin = new Styles {
        val margin = theme.spacing(1)
      }
    }
    s
  })
  
  private[button] val theme = createTheme {
    val t = new js.Object {
      val palette = new js.Object {
        val primary = green
      }
    }
    t
  }

  private[button] lazy val defaultTheme = createTheme(new js.Object)
  
  private[button] val nativeToTheme: js.Function1[NativeTheme, Theme] = { _ =>
    theme
  }
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()

    <.ThemeProvider(^.theme := defaultTheme)(
      <(ColorButton)(^.variant := "contained", ^.color := "primary", ^.className := styleOf(classes.margin))(
        "Custom CSS"
      ),
      <.ThemeProvider(^.theme := nativeToTheme)(
        <.Button(^.variant := "contained", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Theme Provider"
        )
      ),
      <(BootstrapButton)(^.variant := "contained", ^.color := "primary", ^.disableRipple(), ^.className := styleOf(classes.margin))(
        "Bootstrap"
      )
    )
  }
}
