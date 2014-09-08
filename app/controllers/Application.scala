package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.Logger

import models.User
import models.daos.UserDAO

import org.joda.time._

object Application extends Controller {

  val loginForm = Form(
    tuple(
      "username" -> text,
      "password" -> text
    )
  )

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def proxy = Action {
    Ok(views.html.proxy())
  }

  def login = Action { implicit request =>

    val (username, password) = loginForm.bindFromRequest.get

    UserDAO.find(username, password).map{ user =>

      val loggedUser = user.copy(loginDateTime = Some(DateTime.now))
      UserDAO.save(loggedUser)
      Logger.info(user.toString);
      
      Ok("Hello World")

    }.getOrElse{
      Ok(views.html.failedLogin())
    }

    
  }

}