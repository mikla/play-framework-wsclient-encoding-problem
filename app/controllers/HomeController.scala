package controllers

import javax.inject._
import play.api.libs.ws.WSClient
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class HomeController @Inject()(cc: ControllerComponents, ahc: WSClient)
  extends AbstractController(cc) {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def utf8response() = Action { implicit req =>
    val utf8String = "āčēģīķļņšūž ĀČĒĢĪĶĻŅŠŪŽ"

    // Ok(utf8String).as("text/json; charset=utf-8") - works fine
    Ok(utf8String).as(JSON)
  }

  def requestEmployee() = Action.async { implicit req =>
    ahc.url("http://localhost:9000/utf8response")
      .get().map(r => Ok(r.body).as(JSON))
  }

}
