package scommons.doctrine

import scommons.doctrine.DoctrineType._
import scommons.doctrine.raw.{DoctrineNativeType => NativeType, DoctrineNativeTypeName => TypeName, _}

import scala.scalajs.js
import scala.util.{Failure, Success, Try}

/**
 * Doctrine is a JSDoc parser.
 * 
 * @see https://www.npmjs.com/package/doctrine
 */
object Doctrine {
  
  private[doctrine] var native = DoctrineNative

  def parse(jsDoc: String): DoctrineAnnotation = {
    val res = native.parse(jsDoc)
    
    DoctrineAnnotation(
      description = res.description,
      tags = res.tags.map { tag =>
        val tagErrors = tag.errors.map(_.toList).getOrElse(Nil)
        val (maybeType, allErrors) = tag.`type`.toOption match {
          case None => (None, tagErrors)
          case Some(t) =>
            Try(toDoctrineType(t)) match {
              case Success(value) => (Some(value), tagErrors)
              case Failure(ex) => (None, s"$ex" :: tagErrors)
            }
        }
        
        DoctrineTag(
          title = tag.title,
          description = tag.description,
          `type` = maybeType,
          name = tag.name.toOption,
          kind = tag.kind.toOption,
          errors = allErrors
        )
      }.toList
    )
  }
  
  private[doctrine] def toDoctrineType(t: NativeType): DoctrineType = t.`type` match {
    case TypeName.AllLiteral => AllLiteral
    case TypeName.ArrayType => new ArrayType(
      elements = toTypeList(t.elements)
    )
    case n@TypeName.FieldType => FieldType(
      key = getOrThrow(t.key, s"$n without key"),
      value = toTypeOpt(t.value)
    )
    case n@TypeName.FunctionType => new FunctionType(
      `this` = getOrThrow(t.`this`.map(toDoctrineType), s"$n without `this`"),
      `new` = getOrThrow(t.`new`.map(toDoctrineType), s"$n without `new`"),
      params = toTypeList(t.params),
      result = toTypeList(t.result)
    )
    case n@TypeName.NameExpression => NameExpression(
      name = getOrThrow(t.name, s"$n without name")
    )
    case n@TypeName.NonNullableType => NonNullableType(
      prefix = getOrThrow(t.prefix, s"$n without prefix"),
      expression = getOrThrow(t.expression.map(toDoctrineType), s"$n without expression")
    )
    case TypeName.NullableLiteral => NullableLiteral
    case n@TypeName.NullableType => NullableType(
      prefix = getOrThrow(t.prefix, s"$n without prefix"),
      expression = getOrThrow(t.expression.map(toDoctrineType), s"$n without expression")
    )
    case TypeName.NullLiteral => NullLiteral
    case n@TypeName.OptionalType => OptionalType(
      expression = getOrThrow(t.expression.map(toDoctrineType), s"$n without expression")
    )
    case n@TypeName.ParameterType => ParameterType(
      name = getOrThrow(t.name, s"$n without name"),
      expression = getOrThrow(t.expression.map(toDoctrineType), s"$n without expression")
    )
    case TypeName.RecordType => RecordType(
      fields = toTypeList(t.fields)
    )
    case TypeName.RestType => RestType(
      expression = toTypeOpt(t.expression)
    )
    case n@TypeName.TypeApplication => TypeApplication(
      expression = getOrThrow(t.expression.map(toDoctrineType), s"$n without expression"),
      applications = toTypeList(t.applications)
    )
    case TypeName.UndefinedLiteral => UndefinedLiteral
    case TypeName.UnionType => UnionType(
      elements = toTypeList(t.elements)
    )
    case TypeName.VoidLiteral => VoidLiteral
    case typeName =>
      throw new IllegalStateException(s"Unknown Tag type: $typeName")
  }

  private def getOrThrow[T](maybeValue: js.UndefOr[T], error: => String): T = {
    maybeValue.getOrElse(throw new IllegalStateException(error))
  }

  private def toTypeList(maybeArray: js.UndefOr[js.Array[NativeType]]): List[DoctrineType] = {
    maybeArray.map(_.toList).getOrElse(Nil).map(toDoctrineType)
  }
  
  private def toTypeOpt(maybeType: js.UndefOr[NativeType]): Option[DoctrineType] = {
    maybeType.map(toDoctrineType).toOption
  }
}
