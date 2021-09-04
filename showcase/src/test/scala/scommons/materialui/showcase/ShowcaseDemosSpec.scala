package scommons.materialui.showcase

import scommons.materialui.showcase.ShowcaseDemos._
import scommons.react._
import scommons.react.test._

class ShowcaseDemosSpec extends TestSpec with TestRendererUtils {

  ShowcaseDemos.containedButtonsComp = () => "ContainedButtons".asInstanceOf[ReactClass]
  ShowcaseDemos.disableElevationComp = () => "DisableElevation".asInstanceOf[ReactClass]

  it should "render component" in {
    //given
    val component = <(ShowcaseDemos())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div()(
        <.h2()("Contained Buttons"),
        <.hr.empty,
        <(containedButtonsComp())()(),

        <.h4()("Disable Elevation"),
        <.hr.empty,
        <(disableElevationComp())()()
      )
    )
  }
}
