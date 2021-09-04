package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react.test._

class DisableElevationSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(DisableElevation())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.Button(^.variant := "contained", ^.color := "primary", ^.disableElevation := true)(
        "Disable elevation"
      )
    )
  }
}
