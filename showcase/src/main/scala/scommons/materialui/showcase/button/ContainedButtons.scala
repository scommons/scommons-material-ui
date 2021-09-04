package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react._

object ContainedButtons extends FunctionComponent[Unit] {
  
  protected def render(compProps: Props): ReactElement = {
    <.div()(
      <.Button(^.variant := "contained")("Default"),
      <.Button(^.variant := "contained", ^.color := "primary")(
        "Primary"
      ),
      <.Button(^.variant := "contained", ^.color := "secondary")(
        "Secondary"
      ),
      <.Button(^.variant := "contained", ^.disabled := true)(
        "Disabled"
      ),
      <.Button(^.variant := "contained", ^.color := "primary", ^.href := "#contained-buttons")(
        "Link"
      )
    )
  }
}
