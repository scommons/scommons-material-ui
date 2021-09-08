package scommons.materialui.showcase.button

import scommons.materialui.Icons.PhotoCamera
import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object UploadButtons extends FunctionComponent[Unit] {
  
  private val useStyles = makeStyles(theme => {
    val s = new Styles {
      val root = new Styles {
        val `& > *` = new Styles {
          val margin = theme.spacing(1)
        }
      }
      val input = new Styles {
        val display = "none"
      }
    }
    s
  })
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()
    
    <.div(^.className := styleOf(classes.root))(
      <.input(
        ^.accept := "image/*",
        ^.className := styleOf(classes.input),
        ^.id := "contained-button-file",
        ^.multiple := true,
        ^.`type` := "file"
      )(),
      <.label(^.htmlFor := "contained-button-file")(
        <.Button(^.variant := "contained", ^.color := "primary", ^.component := "span")(
          "Upload"
        )
      ),

      <.input(^.accept := "image/*", ^.className := styleOf(classes.input), ^.id := "icon-button-file", ^.`type` := "file")(),
      <.label(^.htmlFor := "icon-button-file")(
        <.IconButton(^.color := "primary", ^("aria-label") := "upload picture", ^.component := "span")(
          <(PhotoCamera)()()
        )
      )
    )
  }
}
