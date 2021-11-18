package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.{
  CloudUpload => CloudUploadIcon,
  Delete => DeleteIcon,
  KeyboardVoice => KeyboardVoiceIcon,
  Save => SaveIcon
}
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.ReactElement
import scommons.react.test._

class IconLabelButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(IconLabelButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(IconLabelButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result, <.div()(), inside(_) { case List(b1, b2, b3, b4, b5, b6) =>
      val b1Icon = b1.props.startIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b1Icon).root, <(DeleteIcon)()())
      assertNativeComponent(b1,
        <.Button(
          ^.variant := "contained",
          ^.color := "secondary",
          ^.className := styleOf(classes.button)
        )(
          "Delete"
        )
      )

      val b2Icon = b2.props.endIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b2Icon).root, <.Icon()("send"))
      assertNativeComponent(b2,
        <.Button(
          ^.variant := "contained",
          ^.color := "primary",
          ^.className := styleOf(classes.button)
        )(
          "Send"
        )
      )

      val b3Icon = b3.props.startIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b3Icon).root, <(CloudUploadIcon)()())
      assertNativeComponent(b3,
        <.Button(
          ^.variant := "contained",
          ^.color := "default",
          ^.className := styleOf(classes.button)
        )(
          "Upload"
        )
      )

      val b4Icon = b4.props.startIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b4Icon).root, <(KeyboardVoiceIcon)()())
      assertNativeComponent(b4,
        <.Button(
          ^.variant := "contained",
          ^.disabled(),
          ^.color := "secondary",
          ^.className := styleOf(classes.button)
        )(
          "Talk"
        )
      )

      val b5Icon = b5.props.startIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b5Icon).root, <(SaveIcon)()())
      assertNativeComponent(b5,
        <.Button(
          ^.variant := "contained",
          ^.color := "primary",
          ^.muiSize := "small",
          ^.className := styleOf(classes.button)
        )(
          "Save"
        )
      )

      val b6Icon = b6.props.startIcon.asInstanceOf[ReactElement]
      assertNativeComponent(createTestRenderer(b6Icon).root, <(SaveIcon)()())
      assertNativeComponent(b6,
        <.Button(
          ^.variant := "contained",
          ^.color := "primary",
          ^.muiSize := "large",
          ^.className := styleOf(classes.button)
        )(
          "Save"
        )
      )
    })
  }
}
