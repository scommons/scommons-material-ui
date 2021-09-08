package scommons.materialui.showcase.button

import scommons.materialui.Icons.{
  AddShoppingCart => AddShoppingCartIcon,
  Alarm => AlarmIcon,
  Delete => DeleteIcon
}
import scommons.materialui._
import scommons.react.test._

class IconButtonsSpec extends TestSpec with TestRendererUtils {

  it should "render component" in {
    //given
    val component = <(IconButtons())()()
    
    //when
    val result = testRender(component)
    
    //then
    assertNativeComponent(result,
      <.div(^.className := "classes.root")(
        <.IconButton(^("aria-label") := "delete")(
          <(DeleteIcon)()()
        ),
        <.IconButton(^("aria-label") := "delete", ^.disabled := true, ^.color := "primary")(
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
