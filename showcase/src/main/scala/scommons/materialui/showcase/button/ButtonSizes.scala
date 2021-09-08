package scommons.materialui.showcase.button

import scommons.materialui.Icons.{ArrowDownward => ArrowDownwardIcon, Delete => DeleteIcon}
import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object ButtonSizes extends FunctionComponent[Unit] {
  
  private val useStyles = makeStyles(theme => {
    val s = new Styles {
      val margin = new Styles {
        val margin = theme.spacing(1)
      }
    }
    s
  })
  
  protected def render(compProps: Props): ReactElement = {
    val classes = useStyles()
    
    <.div()(
      <.div()(
        <.Button(^.muSize := "small", ^.className := styleOf(classes.margin))(
          "Small"
        ),
        <.Button(^.muSize := "medium", ^.className := styleOf(classes.margin))(
          "Medium"
        ),
        <.Button(^.muSize := "large", ^.className := styleOf(classes.margin))(
          "Large"
        )
      ),
      <.div()(
        <.Button(^.variant := "outlined", ^.muSize := "small", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Small"
        ),
        <.Button(^.variant := "outlined", ^.muSize := "medium", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Medium"
        ),
        <.Button(^.variant := "outlined", ^.muSize := "large", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Large"
        )
      ),
      <.div()(
        <.Button(^.variant := "contained", ^.muSize := "small", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Small"
        ),
        <.Button(^.variant := "contained", ^.muSize := "medium", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Medium"
        ),
        <.Button(^.variant := "contained", ^.muSize := "large", ^.color := "primary", ^.className := styleOf(classes.margin))(
          "Large"
        )
      ),
      <.div()(
        <.IconButton(^("aria-label") := "delete", ^.className := styleOf(classes.margin), ^.muSize := "small")(
          <(ArrowDownwardIcon)(^.fontSize := "inherit")()
        ),
        <.IconButton(^("aria-label") := "delete", ^.className := styleOf(classes.margin))(
          <(DeleteIcon)(^.fontSize := "small")()
        ),
        <.IconButton(^("aria-label") := "delete", ^.className := styleOf(classes.margin))(
          <(DeleteIcon)()()
        ),
        <.IconButton(^("aria-label") := "delete", ^.className := styleOf(classes.margin))(
          <(DeleteIcon)(^.fontSize := "large")()
        )
      )
    )
  }
}
