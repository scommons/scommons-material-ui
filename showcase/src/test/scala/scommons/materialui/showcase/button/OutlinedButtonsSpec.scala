package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class OutlinedButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(OutlinedButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(OutlinedButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
        <.Button(^.variant := "outlined")("Default"),
        <.Button(^.variant := "outlined", ^.color := "primary")(
          "Primary"
        ),
        <.Button(^.variant := "outlined", ^.color := "secondary")(
          "Secondary"
        ),
        <.Button(^.variant := "outlined", ^.disabled())(
          "Disabled"
        ),
        <.Button(^.variant := "outlined", ^.color := "primary", ^.href := "#outlined-buttons")(
          "Link"
        )
      )
    )
  }
}
