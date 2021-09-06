package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react.test._

class ContainedButtonsSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(ContainedButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := "classes.root")(
        <.Button(^.variant := "contained")("Default"),
        <.Button(^.variant := "contained", ^.color := "primary")(
          "Primary"
        ),
        <.Button(^.variant := "contained", ^.color := "secondary")(
          "Secondary"
        ),
        <.Button(^.variant := "contained", ^.disabled := true)(
          "Disabled"
        ),
        <.Button(^.variant := "contained", ^.color := "primary", ^.href := "#contained-buttons")(
          "Link"
        )
      )
    )
  }
}
