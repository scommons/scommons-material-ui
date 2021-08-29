package scommons.doctrine

sealed trait DoctrineType

object DoctrineType {

  case object AllLiteral extends DoctrineType

  case class ArrayType(elements: List[DoctrineType]) extends DoctrineType
  
  case class FieldType(key: String, value: Option[DoctrineType]) extends DoctrineType
  
  case class FunctionType(`this`: DoctrineType,
                          `new`: DoctrineType,
                          params: List[DoctrineType],
                          result: List[DoctrineType]) extends DoctrineType

  case class NameExpression(name: String) extends DoctrineType
  
  case class NonNullableType(prefix: Boolean, expression: DoctrineType) extends DoctrineType
  
  case object NullableLiteral extends DoctrineType
  
  case class NullableType(prefix: Boolean, expression: DoctrineType) extends DoctrineType
  
  case object NullLiteral extends DoctrineType
  
  case class OptionalType(expression: DoctrineType) extends DoctrineType
  
  case class ParameterType(name: String, expression: DoctrineType) extends DoctrineType
  
  case class RecordType(fields: List[DoctrineType]) extends DoctrineType
  
  case class RestType(expression: Option[DoctrineType]) extends DoctrineType
  
  case class TypeApplication(expression: DoctrineType,
                             applications: List[DoctrineType]) extends DoctrineType
  
  case object UndefinedLiteral extends DoctrineType
  
  case class UnionType(elements: List[DoctrineType]) extends DoctrineType
  
  case object VoidLiteral extends DoctrineType
}
