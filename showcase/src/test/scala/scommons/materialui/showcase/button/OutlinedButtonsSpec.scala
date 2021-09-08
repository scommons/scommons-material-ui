package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react.test._

class OutlinedButtonsSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(OutlinedButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := "classes.root")(
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
    )
  }
}
