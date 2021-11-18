package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object ContainedButtons extends FunctionComponent[Unit] {
  
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
      <.Button(^.variant := "contained")("Default"),
      <.Button(^.variant := "contained", ^.color := "primary")(
        "Primary"
      ),
      <.Button(^.variant := "contained", ^.color := "secondary")(
        "Secondary"
      ),
      <.Button(^.variant := "contained", ^.disabled())(
        "Disabled"
      ),
      <.Button(^.variant := "contained", ^.color := "primary", ^.href := "#contained-buttons")(
        "Link"
      )
    )
  }
}
