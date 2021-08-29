package scommons.doctrine

import scommons.doctrine.Doctrine.toDoctrineType
import scommons.doctrine.DoctrineType._
import scommons.doctrine.raw.{DoctrineNative, DoctrineNativeAnnotation}
import scommons.nodejs.test.TestSpec

import scala.scalajs.js
import scala.scalajs.js.Dynamic.literal

class DoctrineSpec extends TestSpec {

  it should "return errors if no tag type when parse" in {
    //given
    val parse: js.Function1[String, DoctrineNativeAnnotation] = { _ =>
      literal(
        "description" -> "test description",
        "tags" -> js.Array(literal(
          "title" -> "test title",
          "description" -> "test tag description",
          "errors" -> js.Array("test error")
        ))
      ).asInstanceOf[DoctrineNativeAnnotation]
    }
    val savedNative = Doctrine.native
    Doctrine.native = literal("parse" -> parse).asInstanceOf[DoctrineNative.type]
    
    //when
    val result = Doctrine.parse("some jsDoc")
    
    //then
    Doctrine.native = savedNative

    result shouldBe DoctrineAnnotation(
      description = "test description",
      tags = List(
        DoctrineTag(
          title = "test title",
          description = "test tag description",
          `type` = None,
          name = None,
          kind = None,
          errors = List("test error")
        )
      )
    )
  }

  it should "return tag and errors when parse" in {
    //given
    val parse: js.Function1[String, DoctrineNativeAnnotation] = { _ =>
      literal(
        "description" -> "test description",
        "tags" -> js.Array(literal(
          "title" -> "test title",
          "description" -> "test tag description",
          "type" -> literal("type" -> "AllLiteral"),
          "name" -> "test name",
          "kind" -> "test kind",
          "errors" -> js.Array("test error")
        ))
      ).asInstanceOf[DoctrineNativeAnnotation]
    }
    val savedNative = Doctrine.native
    Doctrine.native = literal("parse" -> parse).asInstanceOf[DoctrineNative.type]
    
    //when
    val result = Doctrine.parse("some jsDoc")
    
    //then
    Doctrine.native = savedNative

    result shouldBe DoctrineAnnotation(
      description = "test description",
      tags = List(
        DoctrineTag(
          title = "test title",
          description = "test tag description",
          `type` = Some(AllLiteral),
          name = Some("test name"),
          kind = Some("test kind"),
          errors = List("test error")
        )
      )
    )
  }

  it should "return extended errors if cannot convert tag when parse" in {
    //given
    val parse: js.Function1[String, DoctrineNativeAnnotation] = { _ =>
      literal(
        "description" -> "test description",
        "tags" -> js.Array(literal(
          "title" -> "test title",
          "description" -> "test tag description",
          "type" -> literal("type" -> "SomeUnknownType"),
          "name" -> "test name",
          "kind" -> "test kind",
          "errors" -> js.Array("test error")
        ))
      ).asInstanceOf[DoctrineNativeAnnotation]
    }
    val savedNative = Doctrine.native
    Doctrine.native = literal("parse" -> parse).asInstanceOf[DoctrineNative.type]
    
    //when
    val result = Doctrine.parse("some jsDoc")
    
    //then
    Doctrine.native = savedNative

    result shouldBe DoctrineAnnotation(
      description = "test description",
      tags = List(
        DoctrineTag(
          title = "test title",
          description = "test tag description",
          `type` = None,
          name = Some("test name"),
          kind = Some("test kind"),
          errors = List(
            "java.lang.IllegalStateException: Unknown Tag type: SomeUnknownType",
            "test error"
          )
        )
      )
    )
  }

  it should "parse JS doc annotation when parse" in {
    //when
    val result = Doctrine.parse(
      """Callback fired when the expand/collapse state is changed.
        |
        |@param {React.SyntheticEvent} event The event source of the callback. **Warning**: This is a generic event.
        |@param {boolean} expanded The `expanded` state of the accordion.
        |""".stripMargin
    )
    
    //then
    result shouldBe DoctrineAnnotation(
      description = "Callback fired when the expand/collapse state is changed.",
      tags = List(
        DoctrineTag(
          title = "param",
          description = "The event source of the callback. **Warning**: This is a generic event.",
          `type` = Some(NameExpression(
            name = "React.SyntheticEvent"
          )),
          name = Some("event"),
          kind = None,
          errors = Nil
        ),
        DoctrineTag(
          title = "param",
          description = "The `expanded` state of the accordion.",
          `type` = Some(NameExpression(
            name = "boolean"
          )),
          name = Some("expanded"),
          kind = None,
          errors = Nil
        )
      )
    )
  }

  it should "return AllLiteral when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "AllLiteral"))) shouldBe AllLiteral
  }

  it should "return ArrayType with empty elements when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "ArrayType"))) shouldBe ArrayType(Nil)
  }

  it should "return ArrayType with non-empty elements when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "ArrayType",
      "elements" -> js.Array(literal("type" -> "AllLiteral"))
    ))) shouldBe ArrayType(List(AllLiteral))
  }
  
  it should "fail if no key when toDoctrineType(FieldType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal("type" -> "FieldType")))
    }
    
    //then
    ex.getMessage shouldBe "FieldType without key"
  }

  it should "return FieldType when toDoctrineType(FieldType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "FieldType",
      "key" -> "test key",
      "value" -> literal("type" -> "AllLiteral")
    ))) shouldBe FieldType("test key", Some(AllLiteral))
  }

  it should "fail if no this when toDoctrineType(FunctionType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal("type" -> "FunctionType")))
    }
    
    //then
    ex.getMessage shouldBe "FunctionType without `this`"
  }

  it should "fail if no new when toDoctrineType(FunctionType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "FunctionType",
        "this" -> literal("type" -> "AllLiteral")
      )))
    }
    
    //then
    ex.getMessage shouldBe "FunctionType without `new`"
  }

  it should "return FunctionType when toDoctrineType(FunctionType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "FunctionType",
      "this" -> literal("type" -> "NameExpression", "name" -> "test this"),
      "new" -> literal("type" -> "NameExpression", "name" -> "test new"),
      "params" -> js.Array(literal("type" -> "NameExpression", "name" -> "test param")),
      "result" -> js.Array(literal("type" -> "NameExpression", "name" -> "test result"))
    ))) shouldBe FunctionType(
      `this` = NameExpression("test this"),
      `new` = NameExpression("test new"),
      params = List(NameExpression("test param")),
      result = List(NameExpression("test result"))
    )
  }

  it should "fail if no name when toDoctrineType(NameExpression)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "NameExpression"
      )))
    }

    //then
    ex.getMessage shouldBe "NameExpression without name"
  }

  it should "return NameExpression when toDoctrineType(NameExpression)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "NameExpression",
      "name" -> "test name"
    ))) shouldBe NameExpression("test name")
  }

  it should "fail if no prefix when toDoctrineType(NonNullableType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "NonNullableType"
      )))
    }

    //then
    ex.getMessage shouldBe "NonNullableType without prefix"
  }

  it should "fail if no expression when toDoctrineType(NonNullableType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "NonNullableType",
        "prefix" -> true
      )))
    }

    //then
    ex.getMessage shouldBe "NonNullableType without expression"
  }

  it should "return NonNullableType when toDoctrineType(NonNullableType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "NonNullableType",
      "prefix" -> true,
      "expression" -> literal("type" -> "AllLiteral")
    ))) shouldBe NonNullableType(prefix = true, AllLiteral)
  }

  it should "return NullableLiteral when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "NullableLiteral"))) shouldBe NullableLiteral
  }

  it should "fail if no prefix when toDoctrineType(NullableType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "NullableType"
      )))
    }

    //then
    ex.getMessage shouldBe "NullableType without prefix"
  }

  it should "fail if no expression when toDoctrineType(NullableType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "NullableType",
        "prefix" -> true
      )))
    }

    //then
    ex.getMessage shouldBe "NullableType without expression"
  }

  it should "return NullableType when toDoctrineType(NullableType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "NullableType",
      "prefix" -> true,
      "expression" -> literal("type" -> "AllLiteral")
    ))) shouldBe NullableType(prefix = true, AllLiteral)
  }

  it should "return NullLiteral when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "NullLiteral"))) shouldBe NullLiteral
  }

  it should "fail if no expression when toDoctrineType(OptionalType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "OptionalType"
      )))
    }

    //then
    ex.getMessage shouldBe "OptionalType without expression"
  }

  it should "return OptionalType when toDoctrineType(OptionalType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "OptionalType",
      "expression" -> literal("type" -> "AllLiteral")
    ))) shouldBe OptionalType(AllLiteral)
  }

  it should "fail if no name when toDoctrineType(ParameterType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "ParameterType"
      )))
    }

    //then
    ex.getMessage shouldBe "ParameterType without name"
  }

  it should "fail if no expression when toDoctrineType(ParameterType)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "ParameterType",
        "name" -> "test name"
      )))
    }

    //then
    ex.getMessage shouldBe "ParameterType without expression"
  }

  it should "return ParameterType when toDoctrineType(ParameterType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "ParameterType",
      "name" -> "test name",
      "expression" -> literal("type" -> "AllLiteral")
    ))) shouldBe ParameterType("test name", AllLiteral)
  }

  it should "return RecordType when toDoctrineType(RecordType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "RecordType",
      "fields" -> js.Array(literal("type" -> "AllLiteral"))
    ))) shouldBe RecordType(List(AllLiteral))
  }

  it should "return RestType without expression when toDoctrineType(RestType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "RestType"
    ))) shouldBe RestType(None)
  }

  it should "return RestType with expression when toDoctrineType(RestType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "RestType",
      "expression" -> literal("type" -> "AllLiteral")
    ))) shouldBe RestType(Some(AllLiteral))
  }

  it should "fail if no expression when toDoctrineType(TypeApplication)" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "TypeApplication"
      )))
    }

    //then
    ex.getMessage shouldBe "TypeApplication without expression"
  }

  it should "return TypeApplication when toDoctrineType(TypeApplication)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "TypeApplication",
      "expression" -> literal("type" -> "NameExpression", "name" -> "test expression"),
      "applications" -> js.Array(literal("type" -> "AllLiteral"))
    ))) shouldBe TypeApplication(NameExpression("test expression"), List(AllLiteral))
  }

  it should "return UndefinedLiteral when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "UndefinedLiteral"))) shouldBe UndefinedLiteral
  }

  it should "return UnionType when toDoctrineType(UnionType)" in {
    //when & then
    toDoctrineType(toNativeType(literal(
      "type" -> "UnionType",
      "elements" -> js.Array(literal("type" -> "AllLiteral"))
    ))) shouldBe UnionType(List(AllLiteral))
  }

  it should "return VoidLiteral when toDoctrineType" in {
    //when & then
    toDoctrineType(toNativeType(literal("type" -> "VoidLiteral"))) shouldBe VoidLiteral
  }

  it should "fail if unknown type when toDoctrineType" in {
    //when
    val ex = the[IllegalStateException] thrownBy {
      toDoctrineType(toNativeType(literal(
        "type" -> "SomeUnknownType"
      )))
    }

    //then
    ex.getMessage shouldBe "Unknown Tag type: SomeUnknownType"
  }

  private def toNativeType(t: js.Dynamic): raw.DoctrineNativeType = {
    t.asInstanceOf[raw.DoctrineNativeType]
  }
}
