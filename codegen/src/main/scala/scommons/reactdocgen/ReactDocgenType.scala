package scommons.reactdocgen

sealed trait ReactDocgenType

object ReactDocgenType {
  
  case object Any extends ReactDocgenType
  case object Obj extends ReactDocgenType
  case object Str extends ReactDocgenType
  case object Num extends ReactDocgenType
  case object Bool extends ReactDocgenType
  case object Func extends ReactDocgenType
  case class Union(types: ReactDocgenType*) extends ReactDocgenType
}
