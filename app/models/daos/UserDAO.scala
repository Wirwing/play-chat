package models.daos

import models.User
import play.api.db.slick._
import play.api.db.slick.Config.driver.simple._
import models.daos.DBTableDefinitions._
import scala.concurrent.Future
import play.Logger

object UserDAO {

  import play.api.Play.current

  def all = {
    DB withSession { implicit session =>
      slickUsers.list
    }
  }

  def find(username: String, password: String) = {
    DB withSession { implicit session =>
      slickUsers.filter(_.username === username).filter(_.password === password).firstOption
    }
  }

  def find(id: Long) = {
    DB withSession { implicit session =>
      slickUsers.filter(_.id === id).firstOption
    }
  }
  
  def save(user: User) = {
    DB withSession { implicit session =>
      Future.successful {
        slickUsers.filter(_.id === user.id).firstOption match {
          case Some(userFound) => slickUsers.filter(_.id === user.id).update(user)
          case None => slickUsers.insert(user)
        }
        user
      }
    }
  }
}
