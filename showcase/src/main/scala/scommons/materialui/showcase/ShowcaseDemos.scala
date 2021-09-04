package scommons.materialui.showcase

import scommons.materialui.showcase.button._
import scommons.react._

object ShowcaseDemos extends FunctionComponent[Unit] {
  
  private[showcase] var containedButtonsComp: UiComponent[Unit] = ContainedButtons
  private[showcase] var disableElevationComp: UiComponent[Unit] = DisableElevation

  protected def render(compProps: Props): ReactElement = {
    <.div()(
      <.h2()("Contained Buttons"),
      <.hr()(),
      <(containedButtonsComp())()(),

      <.h4()("Disable Elevation"),
      <.hr()(),
      <(disableElevationComp())()()
    )
  }
}
