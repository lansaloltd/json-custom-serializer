package com.lansalo.routes

import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.{delete, get, post}
import akka.http.scaladsl.server.directives.PathDirectives.path
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.pattern.ask
import akka.util.Timeout
import com.lansalo.model.{Age, Male, User}
import com.lansalo.service.BogusService

import scala.concurrent.Future
import scala.concurrent.duration._
import akka.actor.{ActorRef, ActorSystem}
import akka.event.Logging

import scala.concurrent.duration._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.directives.MethodDirectives.delete
import akka.http.scaladsl.server.directives.MethodDirectives.get
import akka.http.scaladsl.server.directives.MethodDirectives.post
import akka.http.scaladsl.server.directives.RouteDirectives.complete
import akka.http.scaladsl.server.directives.PathDirectives.path
import org.json4s.{DefaultFormats, jackson}

import scala.concurrent.Future
import akka.pattern.ask
import akka.util.Timeout
import com.lansalo.json.JsonSupport
import de.heikoseeberger.akkahttpjson4s.Json4sSupport

trait UserRoutes extends JsonSupport {

  implicit def system: ActorSystem

  lazy val log = Logging(system, classOf[UserRoutes])

  //lazy val bogusService = new BogusService

  //def userRegistryActor: ActorRef

  implicit lazy val timeout = Timeout(5.seconds)
  import Json4sSupport._

  implicit val serialization = jackson.Serialization // or native.Serialization



  lazy val userRoutes: Route = pathPrefix("users") {
    pathEnd {
      post {
        entity(as[User]) { user =>
          println(s"Received user: $user")
          complete((StatusCodes.Created, "OK"))
        }
      }
    } ~
      path(Segment) { name =>
        get {
          complete(User("Lorenzo", new Age(22), Male))
        }

      }
  }

}
