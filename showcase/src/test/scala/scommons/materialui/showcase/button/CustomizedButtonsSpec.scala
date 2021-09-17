package scommons.materialui.showcase.button

import scommons.materialui.showcase.button.CustomizedButtons._
import scommons.materialui._
import scommons.materialui.styles._
import scommons.react.test._

class CustomizedButtonsSpec extends TestSpec with TestRendererUtils {

  it should "return theme from ThemeProvider.theme prop func" in {
    //given
    val comp = testRender(<(CustomizedButtons())()())
    val  themeProv = inside(findComponents(comp, <.ThemeProvider.reactClass)) {
      case List(_, themeProv) => themeProv
    }

    //when
    val result = themeProv.props.theme(null)

    //then
    result shouldBe theme
  }
  
  it should "render component" in {
    //given
    val component = <(CustomizedButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.ThemeProvider(^.theme := defaultTheme)(
        <(ColorButton)(^.variant := "contained", ^.color := "primary", ^.className := "classes.margin")(
          "Custom CSS"
        ),
        <.ThemeProvider()(
          <.Button(^.variant := "contained", ^.color := "primary", ^.className := "classes.margin")(
            "Theme Provider"
          )
        ),
        <(BootstrapButton)(^.variant := "contained", ^.color := "primary", ^.disableRipple := true, ^.className := "classes.margin")(
          "Bootstrap"
        )
      )
    )
  }
}
