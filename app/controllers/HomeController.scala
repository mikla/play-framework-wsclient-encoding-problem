package controllers

import javax.inject._

import io.circe._
import io.circe.generic.semiauto._
import io.circe.syntax._
import play.api.libs.circe.Circe
import play.api.libs.ws.WSClient
import play.api.mvc._

import scala.concurrent.ExecutionContext.Implicits.global

case class Employee(name: String)

@Singleton
class HomeController @Inject()(ahc: WSClient)
  extends Controller
    with Circe {

  implicit val employeeDecoder: Decoder[Employee] = deriveDecoder[Employee]
  implicit val employeeEncoder: Encoder[Employee] = deriveEncoder[Employee]

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def utf8response() = Action { implicit req =>
    val employee = Employee("āčēģīķļņšūž ĀČĒĢĪĶĻŅŠŪŽ")
    val json = employee.asJson

    Ok(json).as(JSON) // works fine if replace JSON to "text/json; charset=utf-8"
  }

  def requestEmployee() = Action.async { implicit req =>
    ahc.url("http://localhost:9000/utf8response")
      .get().map(r => Ok(r.body).as(JSON))
  }

}
