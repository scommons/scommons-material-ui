package scommons.reactdocgen.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Parses the source into an AST and provides methods to process this AST
 * to extract the desired information.
 *
 * @see https://www.npmjs.com/package/react-docgen
 */
@js.native
@JSImport("react-docgen", JSImport.Default)
object ReactDocgenNative extends js.Object {

  def parse(source: String,
            resolver: js.Function,
            handlers: js.Array[js.Function1[js.Object, Unit]],
            options: ReactDocgenOptions): ReactDocgenNativeResult = js.native
  
  val defaultHandlers: js.Array[js.Function1[js.Object, Unit]] = js.native
}

trait ReactDocgenOptions extends js.Object {
  
  val filename: String
}

@js.native
trait ReactDocgenNativeResult extends js.Object {
  
  def description: String
  def displayName: js.UndefOr[String]
  def props: js.UndefOr[js.Dictionary[ReactDocgenNativeProp]]
}

@js.native
trait ReactDocgenNativeProp extends js.Object {

  def `type`: ReactDocgenNativeType
  def required: Boolean
  def description: String
}

@js.native
trait ReactDocgenNativeType extends js.Object {

  def name: ReactDocgenNativeTypeName
  def value: js.UndefOr[js.Any]
}

@js.native
sealed trait ReactDocgenNativeTypeName extends js.Object

object ReactDocgenNativeTypeName {

  val `object`: ReactDocgenNativeTypeName = "object".asInstanceOf[ReactDocgenNativeTypeName]  
  val string: ReactDocgenNativeTypeName = "string".asInstanceOf[ReactDocgenNativeTypeName]  
  val number: ReactDocgenNativeTypeName = "number".asInstanceOf[ReactDocgenNativeTypeName]  
  val bool: ReactDocgenNativeTypeName = "bool".asInstanceOf[ReactDocgenNativeTypeName]  
  val func: ReactDocgenNativeTypeName = "func".asInstanceOf[ReactDocgenNativeTypeName]  
  val union: ReactDocgenNativeTypeName = "union".asInstanceOf[ReactDocgenNativeTypeName]  
}
