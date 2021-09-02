package scommons.reactdocgen

case class ReactDocgenResult(description: String,
                             displayName: Option[String],
                             props: List[ReactDocgenProp])
