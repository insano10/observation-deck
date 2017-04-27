package controllers

import com.typesafe.config.ConfigFactory
import models.AppConfig
import play.api.libs.json._
import play.api.mvc._
import Config._

class Config() extends Controller {

  private val typesafeConfig = ConfigFactory.load(sys.env("CONFIG_FILE"))
  private val daysDataToRetrieve = typesafeConfig.getInt("daysDataToRetrieve")
  private val boardName = typesafeConfig.getString("boardName")
  private val appConfig = new AppConfig(boardName, daysDataToRetrieve)

  def config() = Action(parse.empty) { implicit request =>
    Ok(Json.toJson(appConfig))
  }
}

object Config {
  implicit val AppConfigToJson: Writes[AppConfig] = Json.writes[AppConfig]
}