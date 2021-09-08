package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object TextButtons extends FunctionComponent[Unit] {
  
  private val useStyles = makeStyles(theme => {
    val s = new Styles {
      val root = new Styles {
        val `& > *` = new Styles {
          val margin = theme.spacing(1)
        }
      }
    }
    s
  })
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()
    
    <.div(^.className := styleOf(classes.root))(
      <.Button()("Default"),
      <.Button(^.color := "primary")("Primary"),
      <.Button(^.color := "secondary")("Secondary"),
      <.Button(^.disabled := true)("Disabled"),
      <.Button(^.href := "#text-buttons", ^.color := "primary")(
        "Link"
      )
    )
  }
}
