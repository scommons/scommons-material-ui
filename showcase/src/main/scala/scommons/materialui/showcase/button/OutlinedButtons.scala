package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object OutlinedButtons extends FunctionComponent[Unit] {
  
  private[button] val useStyles = makeStyles(theme => {
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
      <.Button(^.variant := "outlined")("Default"),
      <.Button(^.variant := "outlined", ^.color := "primary")(
        "Primary"
      ),
      <.Button(^.variant := "outlined", ^.color := "secondary")(
        "Secondary"
      ),
      <.Button(^.variant := "outlined", ^.disabled := true)(
        "Disabled"
      ),
      <.Button(^.variant := "outlined", ^.color := "primary", ^.href := "#outlined-buttons")(
        "Link"
      )
    )
  }
}
