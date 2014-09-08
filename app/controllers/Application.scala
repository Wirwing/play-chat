package controllers

import play.api._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._
import play.api.Logger

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

    val (user, password) = loginForm.bindFromRequest.get

    Logger.info(user);
    Logger.info(password);

    Ok("Hello World")
  }

}