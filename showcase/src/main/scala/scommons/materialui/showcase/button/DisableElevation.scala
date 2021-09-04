package scommons.materialui.showcase.button

import scommons.materialui._
import scommons.react._

object DisableElevation extends FunctionComponent[Unit] {
  
  protected def render(compProps: Props): ReactElement = {
    <.Button(^.variant := "contained", ^.color := "primary", ^.disableElevation := true)(
      "Disable elevation"
    )
  }
}
