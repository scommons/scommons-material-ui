package scommons.materialui.showcase.button

import scommons.materialui.Icons.PhotoCamera
import scommons.materialui._
import scommons.react.test._

class UploadButtonsSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(UploadButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := "classes.root")(
        <.input(
          ^.accept := "image/*",
          ^.className := "classes.input",
          ^.id := "contained-button-file",
          ^.multiple := true,
          ^.`type` := "file"
        )(),
        <.label(^.htmlFor := "contained-button-file")(
          <.Button(^.variant := "contained", ^.color := "primary", ^.component := "span")(
            "Upload"
          )
        ),

        <.input(^.accept := "image/*", ^.className := "classes.input", ^.id := "icon-button-file", ^.`type` := "file")(),
        <.label(^.htmlFor := "icon-button-file")(
          <.IconButton(^.color := "primary", ^("aria-label") := "upload picture", ^.component := "span")(
            <(PhotoCamera)()()
          )
        )
      )
    )
  }
}
