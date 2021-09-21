package scommons.materialui.test

import scommons.react._
import scommons.react.test._

import scala.scalajs.js

trait MuiBaseTestSpec extends BaseTestSpec with TestRendererUtils {

  def testClasses(useStyles: js.Function0[js.Dynamic]): js.Dynamic = {
    var classes: js.Dynamic = null
    val wrapper = new FunctionComponent[Unit] {
      protected def render(props: Props): ReactElement = {
        classes = useStyles()
        null
      }
    }

    createTestRenderer(<(wrapper()).empty)
    classes
  }
}
