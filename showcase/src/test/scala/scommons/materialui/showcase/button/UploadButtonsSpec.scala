package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.PhotoCamera
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class UploadButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(UploadButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(UploadButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
        <.input(
          ^.accept := "image/*",
          ^.className := styleOf(classes.input),
          ^.id := "contained-button-file",
          ^.multiple(),
          ^.`type` := "file"
        )(),
        <.label(^.htmlFor := "contained-button-file")(
          <.Button(^.variant := "contained", ^.color := "primary", ^.component := "span")(
            "Upload"
          )
        ),

        <.input(^.accept := "image/*", ^.className := styleOf(classes.input), ^.id := "icon-button-file", ^.`type` := "file")(),
        <.label(^.htmlFor := "icon-button-file")(
          <.IconButton(^.color := "primary", ^("aria-label") := "upload picture", ^.component := "span")(
            <(PhotoCamera)()()
          )
        )
      )
    )
  }
}
