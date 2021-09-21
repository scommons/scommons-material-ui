package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.showcase.button.ButtonBases._
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class ButtonBasesSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(useStyles)

  it should "render component" in {
    //given
    val component = <(ButtonBases())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
        images.map { case (imageUrl, imageTitle, imageWidth) =>
          <.ButtonBase(
            ^.focusRipple := true,
            ^.key := imageTitle,
            ^.className := styleOf(classes.image),
            ^.focusVisibleClassName := styleOf(classes.focusVisible),
            ^.muiStyle := new Styles {
              val width = imageWidth
            }
          )(
            <.span(
              ^.className := styleOf(classes.imageSrc),
              ^.muiStyle := new Styles {
                val backgroundImage = s"url($imageUrl)"
              }
            )(),
            <.span(^.className := styleOf(classes.imageBackdrop))(),
            <.span(^.className := styleOf(classes.imageButton))(
              <.Typography(
                ^.component := "span",
                ^.variant := "subtitle1",
                ^.color := "inherit",
                ^.className := styleOf(classes.imageTitle)
              )(
                imageTitle,
                <.span(^.className := styleOf(classes.imageMarked))()
              )
            )
          )
        }
      )
    )
  }
}
