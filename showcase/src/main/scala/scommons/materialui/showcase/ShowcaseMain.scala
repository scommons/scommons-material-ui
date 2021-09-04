package scommons.materialui.showcase

import io.github.shogowada.scalajs.reactjs.ReactDOM
import org.scalajs.dom
import scommons.react._

object ShowcaseMain {

  def main(args: Array[String]): Unit = {
    val mountNode = dom.document.getElementById("root")

    dom.document.title = "scommons-material-ui-showcase"

    ReactDOM.render(
      <(ShowcaseDemos()).empty,
      mountNode
    )
  }
}
