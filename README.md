
[![CI](https://github.com/scommons/scommons-material-ui/actions/workflows/ci.yml/badge.svg?branch=master)](https://github.com/scommons/scommons-material-ui/actions/workflows/ci.yml?query=workflow%3Aci+branch%3Amaster)
[![Coverage Status](https://coveralls.io/repos/github/scommons/scommons-material-ui/badge.svg?branch=master)](https://coveralls.io/github/scommons/scommons-material-ui/?branch=master)
[![Scala.js](https://www.scala-js.org/assets/badges/scalajs-1.1.0.svg)](https://www.scala-js.org)

## Scala Commons Material UI

Scala.js facades for [Material-UI (v4)](https://v4.mui.com/getting-started/usage/) components and APIs.

It uses common [scalajs-reactjs](https://github.com/shogowada/scalajs-reactjs) binding/facade library.

### How to add it to your project

```scala
val scommonsMaterialUiVer = "1.0.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.scommons.material-ui" %%% "scommons-material-ui-core" % scommonsMaterialUiVer,
  
  // mocks of native Components and APIs
  "org.scommons.material-ui" %%% "scommons-material-ui-test" % scommonsMaterialUiVer % "test"
)
```

Latest `SNAPSHOT` version is published to [Sonatype Repo](https://oss.sonatype.org/content/repositories/snapshots/org/scommons/), just make sure you added
the proper dependency resolver to your `build.sbt` settings:
```scala
resolvers += "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"
```

### Quick Start

```scala
import io.github.shogowada.scalajs.reactjs.ReactDOM
import org.scalajs.dom
import scommons.materialui._
import scommons.materialui.styles._
import scommons.react._

object App extends FunctionComponent[Unit] {

  protected def render(compProps: Props): ReactElement = {
    <.Button(^.variant := "contained", ^.color := "primary")(
      "Hello World"
    )
  }
}

object AppMain {

  def main(args: Array[String]): Unit = {
    val mountNode = dom.document.getElementById("root")

    dom.document.title = "Demo material-ui app"

    ReactDOM.render(<(App()).empty, mountNode)
  }
}
```

### Components Demos

Please, see [README.md in showcase](showcase/README.md) sub-folder
for how to build and run showcase app locally.

* [Button](https://v4.mui.com/components/buttons/) => [demos](showcase/src/main/scala/scommons/materialui/showcase/button) => [tests](showcase/src/test/scala/scommons/materialui/showcase/button)
* ...TBD
