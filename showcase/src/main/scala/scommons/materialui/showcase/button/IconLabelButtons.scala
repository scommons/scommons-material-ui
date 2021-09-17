package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.{
  CloudUpload => CloudUploadIcon,
  Delete => DeleteIcon,
  KeyboardVoice => KeyboardVoiceIcon,
  Save => SaveIcon
}
import scommons.materialui.styles._
import scommons.react._

object IconLabelButtons extends FunctionComponent[Unit] {
  
  private val useStyles = makeStyles(theme => {
    val s = new Styles {
      val button = new Styles {
        val margin = theme.spacing(1)
      }
    }
    s
  })
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()
    
    <.div()(
      <.Button(
        ^.variant := "contained",
        ^.color := "secondary",
        ^.className := styleOf(classes.button),
        ^.startIcon := <(DeleteIcon)()()
      )(
        "Delete"
      ),
      <.Button(
        ^.variant := "contained",
        ^.color := "primary",
        ^.className := styleOf(classes.button),
        ^.endIcon := <.Icon()("send")
      )(
        "Send"
      ),
      <.Button(
        ^.variant := "contained",
        ^.color := "default",
        ^.className := styleOf(classes.button),
        ^.startIcon := <(CloudUploadIcon)()()
      )(
        "Upload"
      ),
      <.Button(
        ^.variant := "contained",
        ^.disabled := true,
        ^.color := "secondary",
        ^.className := styleOf(classes.button),
        ^.startIcon := <(KeyboardVoiceIcon)()()
      )(
        "Talk"
      ),
      <.Button(
        ^.variant := "contained",
        ^.color := "primary",
        ^.muSize := "small",
        ^.className := styleOf(classes.button),
        ^.startIcon := <(SaveIcon)()()
      )(
        "Save"
      ),
      <.Button(
        ^.variant := "contained",
        ^.color := "primary",
        ^.muSize := "large",
        ^.className := styleOf(classes.button),
        ^.startIcon := <(SaveIcon)()()
      )(
        "Save"
      )
    )
  }
}
