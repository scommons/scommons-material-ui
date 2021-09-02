package scommons.reactdocgen

import scommons.reactdocgen.raw.{ReactDocgenNativeTypeName => TypeName}

import scala.scalajs.js

object ReactDocgen {

  def parse(source: String, options: ReactDocgenOptions): ReactDocgenResult = {
    val res = raw.ReactDocgenNative.parse(source, null, raw.ReactDocgenNative.defaultHandlers, options)
    
    ReactDocgenResult(
      description = res.description,
      displayName = res.displayName.toOption,
      props = res.props.map(_.toList).getOrElse(Nil).map { case (name, prop) =>
        ReactDocgenProp(
          name = name,
          `type` = toReactDocgenType(prop.`type`),
          required = prop.required,
          description = prop.description
        )
      }
    )
  }
  
  private def toReactDocgenType(pt: raw.ReactDocgenNativeType): ReactDocgenType = pt.name match {
    case TypeName.`object` => ReactDocgenType.Obj
    case TypeName.string => ReactDocgenType.Str
    case TypeName.number => ReactDocgenType.Num
    case TypeName.bool => ReactDocgenType.Bool
    case TypeName.func => ReactDocgenType.Func
    case TypeName.union =>
      val types = pt.value.asInstanceOf[js.Array[raw.ReactDocgenNativeType]]
        .toIterable.map(toReactDocgenType).toList
      ReactDocgenType.Union(types: _*)
    case t =>
      ReactDocgenType.Any
  }
}
