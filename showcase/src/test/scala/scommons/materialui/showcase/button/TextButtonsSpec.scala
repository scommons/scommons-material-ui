package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class TextButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(TextButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(TextButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
        <.Button()("Default"),
        <.Button(^.color := "primary")("Primary"),
        <.Button(^.color := "secondary")("Secondary"),
        <.Button(^.disabled := true)("Disabled"),
        <.Button(^.href := "#text-buttons", ^.color := "primary")(
          "Link"
        )
      )
    )
  }
}
