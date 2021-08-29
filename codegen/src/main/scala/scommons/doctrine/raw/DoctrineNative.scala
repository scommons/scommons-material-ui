package scommons.doctrine.raw

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
 * Doctrine is a JSDoc parser.
 *
 * @see https://github.com/DefinitelyTyped/DefinitelyTyped/blob/master/types/doctrine/index.d.ts
 */
@js.native
@JSImport("doctrine", JSImport.Default)
object DoctrineNative extends js.Object {

  def parse(jsDoc: String): DoctrineNativeAnnotation = js.native
}

@js.native
trait DoctrineNativeAnnotation extends js.Object {
  
  def description: String
  def tags: js.Array[DoctrineNativeTag]
}

@js.native
trait DoctrineNativeTag extends js.Object {

  def title: String
  def description: String
  def `type`: js.UndefOr[DoctrineNativeType]
  def name: js.UndefOr[String]
  def kind: js.UndefOr[String]
  def errors: js.UndefOr[js.Array[String]]
}

@js.native
trait DoctrineNativeType extends js.Object {

  def `type`: DoctrineNativeTypeName

  def elements: js.UndefOr[js.Array[DoctrineNativeType]]

  def key: js.UndefOr[String]
  def value: js.UndefOr[DoctrineNativeType]

  def `this`: js.UndefOr[DoctrineNativeType]
  def `new`: js.UndefOr[DoctrineNativeType]
  def params: js.UndefOr[js.Array[DoctrineNativeType]]
  def result: js.UndefOr[js.Array[DoctrineNativeType]]

  def name: js.UndefOr[String]

  def prefix: js.UndefOr[Boolean]
  def expression: js.UndefOr[DoctrineNativeType]

  def fields: js.UndefOr[js.Array[DoctrineNativeType]]
  def applications: js.UndefOr[js.Array[DoctrineNativeType]]
}

@js.native
sealed trait DoctrineNativeTypeName extends js.Object

object DoctrineNativeTypeName {
  
  val AllLiteral: DoctrineNativeTypeName = "AllLiteral".asInstanceOf[DoctrineNativeTypeName]
  val ArrayType: DoctrineNativeTypeName = "ArrayType".asInstanceOf[DoctrineNativeTypeName]
  val FieldType: DoctrineNativeTypeName = "FieldType".asInstanceOf[DoctrineNativeTypeName]
  val FunctionType: DoctrineNativeTypeName = "FunctionType".asInstanceOf[DoctrineNativeTypeName]
  val NameExpression: DoctrineNativeTypeName = "NameExpression".asInstanceOf[DoctrineNativeTypeName]
  val NonNullableType: DoctrineNativeTypeName = "NonNullableType".asInstanceOf[DoctrineNativeTypeName]
  val NullableLiteral: DoctrineNativeTypeName = "NullableLiteral".asInstanceOf[DoctrineNativeTypeName]
  val NullableType: DoctrineNativeTypeName = "NullableType".asInstanceOf[DoctrineNativeTypeName]
  val NullLiteral: DoctrineNativeTypeName = "NullLiteral".asInstanceOf[DoctrineNativeTypeName]
  val OptionalType: DoctrineNativeTypeName = "OptionalType".asInstanceOf[DoctrineNativeTypeName]
  val ParameterType: DoctrineNativeTypeName = "ParameterType".asInstanceOf[DoctrineNativeTypeName]
  val RecordType: DoctrineNativeTypeName = "RecordType".asInstanceOf[DoctrineNativeTypeName]
  val RestType: DoctrineNativeTypeName = "RestType".asInstanceOf[DoctrineNativeTypeName]
  val TypeApplication: DoctrineNativeTypeName = "TypeApplication".asInstanceOf[DoctrineNativeTypeName]
  val UndefinedLiteral: DoctrineNativeTypeName = "UndefinedLiteral".asInstanceOf[DoctrineNativeTypeName]
  val UnionType: DoctrineNativeTypeName = "UnionType".asInstanceOf[DoctrineNativeTypeName]
  val VoidLiteral: DoctrineNativeTypeName = "VoidLiteral".asInstanceOf[DoctrineNativeTypeName]
}
