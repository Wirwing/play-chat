package controllers

import play.api._
import play.api.mvc._

import play.api.libs.json._
import play.api.Logger

import models.Message

object MessageController extends Controller {

  def index = Action {

    // var list: List[Message] = List(
    //     Message("Chido tu coto", "wirwing"),
    //     Message("Orale wey", "john doe")
    //   )

    Ok(Json.toJson(Message.all))
    // Ok(Json.toJson(list))

  }

  def create() : Action[JsValue] = Action(parse.json) { implicit request =>

    request.body.validate[Message].map { message =>

      Message.add(message)
      Ok(Json.toJson(message))

    }.getOrElse(BadRequest("Expecting Json data"))

  }

}