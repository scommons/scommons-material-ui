package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class ContainedButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(ContainedButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(ContainedButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
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
