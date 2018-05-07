name := "json-custom-serializer"

organization := "LansaloLtd"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.3"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= {
  val AkkaVersion       = "2.5.12"
  val AkkaHttpVersion   = "10.1.1"
  val Json4sVersion     = "3.5.3"
  Seq(
    "com.typesafe.akka" %% "akka-slf4j" % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
    "org.json4s"        %% "json4s-native"   % Json4sVersion,
    "org.json4s"        %% "json4s-core"     % Json4sVersion,
    "org.json4s"        %% "json4s-jackson"  % Json4sVersion,
    "org.json4s"        %% "json4s-ext"      % Json4sVersion,
    "de.heikoseeberger" %% "akka-http-json4s" % "1.20.1",
    "org.scalatest" %% "scalatest" % "3.0.1" % Test
  )
}