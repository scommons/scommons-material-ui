package scommons.materialui.showcase.button

import scommons.materialui.showcase.button.ButtonDemos._
import scommons.react._
import scommons.react.test._

class ButtonDemosSpec extends TestSpec with TestRendererUtils {

  ButtonDemos.containedButtonsComp = () => "ContainedButtons".asInstanceOf[ReactClass]
  ButtonDemos.disableElevationComp = () => "DisableElevation".asInstanceOf[ReactClass]
  ButtonDemos.textButtonsComp = () => "TextButtons".asInstanceOf[ReactClass]
  ButtonDemos.outlinedButtonsComp = () => "OutlinedButtons".asInstanceOf[ReactClass]
  ButtonDemos.uploadButtonsComp = () => "UploadButtons".asInstanceOf[ReactClass]
  ButtonDemos.buttonSizesComp = () => "ButtonSizes".asInstanceOf[ReactClass]
  ButtonDemos.iconLabelButtonsComp = () => "IconLabelButtons".asInstanceOf[ReactClass]
  ButtonDemos.iconButtonsComp = () => "IconButtons".asInstanceOf[ReactClass]
  ButtonDemos.customizedButtonsComp = () => "CustomizedButtons".asInstanceOf[ReactClass]
  ButtonDemos.buttonBasesComp = () => "ButtonBases".asInstanceOf[ReactClass]

  it should "render component" in {
    //given
    val component = <(ButtonDemos())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div()(
        <.h3()("Contained Buttons"),
        <.hr.empty,
        <(containedButtonsComp())()(),

        <.h4()("Disable Elevation"),
        <.hr.empty,
        <(disableElevationComp())()(),

        <.h3()("Text Buttons"),
        <.hr.empty,
        <(textButtonsComp())()(),

        <.h3()("Outlined Buttons"),
        <.hr()(),
        <(outlinedButtonsComp())()(),

        <.h3()("Upload Buttons"),
        <.hr()(),
        <(uploadButtonsComp())()(),
        
        <.h3()("Sizes"),
        <.hr()(),
        <(buttonSizesComp())()(),

        <.h3()("Buttons with icons and label"),
        <.hr()(),
        <(iconLabelButtonsComp())()(),

        <.h3()("Icon Buttons"),
        <.hr()(),
        <(iconButtonsComp())()(),

        <.h3()("Customized Buttons"),
        <.hr()(),
        <(customizedButtonsComp())()(),

        <.h3()("Complex Buttons"),
        <.hr()(),
        <(buttonBasesComp())()()
      )
    )
  }
}
