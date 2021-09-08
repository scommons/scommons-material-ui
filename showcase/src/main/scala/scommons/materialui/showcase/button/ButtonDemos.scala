package scommons.materialui.showcase.button

import scommons.react._

/**
 * @see https://material-ui.com/components/buttons/
 */
object ButtonDemos extends FunctionComponent[Unit] {

  private[button] var containedButtonsComp: UiComponent[Unit] = ContainedButtons
  private[button] var disableElevationComp: UiComponent[Unit] = DisableElevation
  private[button] var textButtonsComp: UiComponent[Unit] = TextButtons
  private[button] var outlinedButtonsComp: UiComponent[Unit] = OutlinedButtons
  private[button] var uploadButtonsComp: UiComponent[Unit] = UploadButtons
  private[button] var buttonSizesComp: UiComponent[Unit] = ButtonSizes
  private[button] var iconLabelButtonsComp: UiComponent[Unit] = IconLabelButtons
  private[button] var iconButtonsComp: UiComponent[Unit] = IconButtons

  protected def render(compProps: Props): ReactElement = {
    <.div()(
      <.h3()("Contained Buttons"),
      <.hr()(),
      <(containedButtonsComp())()(),

      <.h4()("Disable Elevation"),
      <.hr()(),
      <(disableElevationComp())()(),

      <.h3()("Text Buttons"),
      <.hr()(),
      <(textButtonsComp())()(),

      <.h3()("Outlined Buttons"),
      <.hr()(),
      <(outlinedButtonsComp())()(),

      <.h3()("Upload Buttons"),
      <.hr()(),
      <(uploadButtonsComp())()(),
      
      <.h3()("Sizes"),
      <.hr()(),
      <(buttonSizesComp())()(),

      <.h3()("Buttons with icons and label"),
      <.hr()(),
      <(iconLabelButtonsComp())()(),

      <.h3()("Icon Buttons"),
      <.hr()(),
      <(iconButtonsComp())()()
    )
  }
}
