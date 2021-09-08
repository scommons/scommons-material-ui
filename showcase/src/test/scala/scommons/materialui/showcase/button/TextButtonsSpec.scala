package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react.test._

class TextButtonsSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(TextButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := "classes.root")(
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
