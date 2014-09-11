package models

import play.api.libs.json._

case class Message (
  text: String,
  username: String
)

object Message{

  implicit val messageFmt = Json.format[Message]

  private var messages: List[Message] = List()

  def all() = messages

  def add(msg: Message) = {
      messages = messages ::: List(msg)
    }

}