package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.{ArrowDownward => ArrowDownwardIcon, Delete => DeleteIcon}
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class ButtonSizesSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(ButtonSizes.useStyles)

  it should "render component" in {
    //given
    val component = <(ButtonSizes())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div()(
        <.div()(
          <.Button(^.muiSize := "small", ^.className := styleOf(classes.margin))(
            "Small"
          ),
          <.Button(^.muiSize := "medium", ^.className := styleOf(classes.margin))(
            "Medium"
          ),
          <.Button(^.muiSize := "large", ^.className := styleOf(classes.margin))(
            "Large"
          )
        ),
        <.div()(
          <.Button(^.variant := "outlined", ^.muiSize := "small", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Small"
          ),
          <.Button(^.variant := "outlined", ^.muiSize := "medium", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Medium"
          ),
          <.Button(^.variant := "outlined", ^.muiSize := "large", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Large"
          )
        ),
        <.div()(
          <.Button(^.variant := "contained", ^.muiSize := "small", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Small"
          ),
          <.Button(^.variant := "contained", ^.muiSize := "medium", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Medium"
          ),
          <.Button(^.variant := "contained", ^.muiSize := "large", ^.color := "primary", ^.className := styleOf(classes.margin))(
            "Large"
          )
        ),
        <.div()(
          <.IconButton(^("aria-label") := "delete", ^.className := styleOf(classes.margin), ^.muiSize := "small")(
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
    )
  }
}
