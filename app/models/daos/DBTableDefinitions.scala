package models.daos

import play.api.db.slick.Config.driver.simple._
import models.User

object DBTableDefinitions {

  class Users(tag: Tag) extends Table[User](tag, "user") {
    def id = column[Option[Long]]("id", O.PrimaryKey, O.AutoInc)
    def username = column[String]("username")
    def password = column[String]("password")
    def * = (id, username, password) <> (User.tupled, User.unapply)
  }
  
  val slickUsers = TableQuery[Users]

}
