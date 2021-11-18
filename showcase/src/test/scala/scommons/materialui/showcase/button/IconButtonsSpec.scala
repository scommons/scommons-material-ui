package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.materialui.icons.{AddShoppingCart => AddShoppingCartIcon, Alarm => AlarmIcon, Delete => DeleteIcon}
import scommons.materialui.styles._
import scommons.materialui.test.MuiBaseTestSpec
import scommons.react.test._

class IconButtonsSpec extends TestSpec with MuiBaseTestSpec {

  private lazy val classes = testClasses(IconButtons.useStyles)

  it should "render component" in {
    //given
    val component = <(IconButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := styleOf(classes.root))(
        <.IconButton(^("aria-label") := "delete")(
          <(DeleteIcon)()()
        ),
        <.IconButton(^("aria-label") := "delete", ^.disabled(), ^.color := "primary")(
          <(DeleteIcon)()()
        ),
        <.IconButton(^.color := "secondary", ^("aria-label") := "add an alarm")(
          <(AlarmIcon)()()
        ),
        <.IconButton(^.color := "primary", ^("aria-label") := "add to shopping cart")(
          <(AddShoppingCartIcon)()()
        )
      )
    )
  }
}
