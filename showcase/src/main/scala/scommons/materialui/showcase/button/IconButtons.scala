package scommons.materialui.showcase.button

import scommons.materialui.Icons.{
  AddShoppingCart => AddShoppingCartIcon,
  Alarm => AlarmIcon,
  Delete => DeleteIcon
}
import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object IconButtons extends FunctionComponent[Unit] {
  
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
      <.IconButton(^("aria-label") := "delete")(
        <(DeleteIcon)()()
      ),
      <.IconButton(^("aria-label") := "delete", ^.disabled := true, ^.color := "primary")(
        <(DeleteIcon)()()
      ),
      <.IconButton(^.color := "secondary", ^("aria-label") := "add an alarm")(
        <(AlarmIcon)()()
      ),
      <.IconButton(^.color := "primary", ^("aria-label") := "add to shopping cart")(
        <(AddShoppingCartIcon)()()
      )
    )
  }
}
