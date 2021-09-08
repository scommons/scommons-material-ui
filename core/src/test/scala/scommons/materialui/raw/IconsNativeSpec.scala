package scommons.materialui.raw

import scommons.nodejs.test.TestSpec
import scommons.nodejs._

import scala.scalajs.js

class IconsNativeSpec extends TestSpec {

  it should "generate IconsNative.scala" in {
    //given
    val srcFile = path.join(
      "core", "src", "main", "scala", "scommons", "materialui", "raw", "IconsNative.scala"
    )
    val icons = js.Object.keys(IconsNative).toList
    icons should contain ("Accessibility")
    
    //when & then
    fs.writeFileSync(srcFile,
      s"""package scommons.materialui.raw
         |
         |import scommons.react.ReactClass
         |
         |import scala.scalajs.js
         |import scala.scalajs.js.annotation.JSImport
         |
         |@js.native
         |@JSImport("@material-ui/icons", JSImport.Default)
         |object IconsNative extends IconsNative
         |
         |@js.native
         |trait IconsNative extends js.Object {
         |  
         |${icons.map {n => s"  val $n: ReactClass = js.native"}.mkString("\n")}
         |}
         |""".stripMargin)
  }

  it should "generate sc-material-ui-icons-mocks.js" in {
    //given
    val srcFile = path.join(
      "test", "src", "main", "resources", "sc-material-ui-icons-mocks.js"
    )
    val icons = js.Object.keys(IconsNative).toList
    icons should contain ("Accessibility")
    
    //when & then
    fs.writeFileSync(srcFile,
      s"""module.exports = {
         |  
         |${icons.map {n => s"  $n: '$n'"}.mkString(",\n")}
         |}
         |""".stripMargin)
  }
}
