package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.Logger

import models.User
import models.daos.UserDAO


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

    val user = UserDAO.find(username, password)
    Logger.info(user.get.toString);

    Ok("Hello World")
  }

}