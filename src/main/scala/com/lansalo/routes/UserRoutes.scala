package com.lansalo.routes

import akka.actor.ActorSystem
import akka.event.Logging
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.{get, post}
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.util.Timeout
import com.lansalo.json.JsonSupport
import com.lansalo.model.{Age, Female, User}
import de.heikoseeberger.akkahttpjson4s.Json4sSupport
import org.json4s.jackson

import scala.concurrent.duration._

trait UserRoutes extends JsonSupport {

  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[UserRoutes])

  implicit lazy val timeout = Timeout(5.seconds)
  import Json4sSupport._

  implicit val serialization = jackson.Serialization // or native.Serialization

  lazy val userRoutes: Route = pathPrefix("users") {
    pathEnd {
      post {
        entity(as[User]) { user =>
          log.info(s"Received user: $user")
          complete((StatusCodes.Created, "OK"))
        }
      }
    } ~
      path(Segment) { name =>
        get {
          complete(User(name, new Age(22), Female))
        }
      }
  }
}
