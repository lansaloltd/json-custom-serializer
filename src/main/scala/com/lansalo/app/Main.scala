package com.lansalo.app

import scala.concurrent.duration._
import akka.actor._
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.ActorMaterializer
import akka.util.Timeout
import com.lansalo.routes.UserRoutes

import scala.concurrent.Await

object Main extends App with UserRoutes {

  val host = "localhost"
  val port = 8080

  implicit val system = ActorSystem("json-custom-serializer")
  implicit val materializer = ActorMaterializer()


  implicit val executionContext = system.dispatcher
  implicit val timeout = Timeout(10 seconds)

  lazy val routes: Route = userRoutes

  Http().bindAndHandle(routes, "localhost", 8080)

  println(s"Server online at http://localhost:8080/")

  Await.result(system.whenTerminated, Duration.Inf)


}
