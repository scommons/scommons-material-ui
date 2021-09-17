package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.{ArrowDownward => ArrowDownwardIcon, Delete => DeleteIcon}
import scommons.react.test._

class ButtonSizesSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ButtonSizes())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div()(
        <.div()(
          <.Button(^.muSize := "small", ^.className := "classes.margin")(
            "Small"
          ),
          <.Button(^.muSize := "medium", ^.className := "classes.margin")(
            "Medium"
          ),
          <.Button(^.muSize := "large", ^.className := "classes.margin")(
            "Large"
          )
        ),
        <.div()(
          <.Button(^.variant := "outlined", ^.muSize := "small", ^.color := "primary", ^.className := "classes.margin")(
            "Small"
          ),
          <.Button(^.variant := "outlined", ^.muSize := "medium", ^.color := "primary", ^.className := "classes.margin")(
            "Medium"
          ),
          <.Button(^.variant := "outlined", ^.muSize := "large", ^.color := "primary", ^.className := "classes.margin")(
            "Large"
          )
        ),
        <.div()(
          <.Button(^.variant := "contained", ^.muSize := "small", ^.color := "primary", ^.className := "classes.margin")(
            "Small"
          ),
          <.Button(^.variant := "contained", ^.muSize := "medium", ^.color := "primary", ^.className := "classes.margin")(
            "Medium"
          ),
          <.Button(^.variant := "contained", ^.muSize := "large", ^.color := "primary", ^.className := "classes.margin")(
            "Large"
          )
        ),
        <.div()(
          <.IconButton(^("aria-label") := "delete", ^.className := "classes.margin", ^.muSize := "small")(
            <(ArrowDownwardIcon)(^.fontSize := "inherit")()
          ),
          <.IconButton(^("aria-label") := "delete", ^.className := "classes.margin")(
            <(DeleteIcon)(^.fontSize := "small")()
          ),
          <.IconButton(^("aria-label") := "delete", ^.className := "classes.margin")(
            <(DeleteIcon)()()
          ),
          <.IconButton(^("aria-label") := "delete", ^.className := "classes.margin")(
            <(DeleteIcon)(^.fontSize := "large")()
          )
        )
      )
    )
  }
}
