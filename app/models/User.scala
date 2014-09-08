package models

import org.joda.time._

case class User (
  id: Option[Long] = None,
  username: String,
  password: String,
  loginDateTime: Option[DateTime] = None
)