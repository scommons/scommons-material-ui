package scommons.doctrine

case class DoctrineTag(title: String,
                       description: String,
                       `type`: Option[DoctrineType],
                       name: Option[String],
                       kind: Option[String],
                       errors: List[String])
