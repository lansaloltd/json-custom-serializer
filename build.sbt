name := "json-custom-serializer"

organization := "LansaloLtd"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.12.3"

/*crossScalaVersions := Seq("2.10.4", "2.11.2")

libraryDependencies ++= Seq(

  "org.json4s" %% "json4s-native" % "3.5.3",
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.13.4" % "test",
  "junit" % "junit" % "4.8.1" % "test"
)*/

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
    //"ch.qos.logback"    %  "logback-classic" % "1.1.2",
    "org.json4s"        %% "json4s-native"   % Json4sVersion,
    "org.json4s"        %% "json4s-core"     % Json4sVersion,
    "org.json4s"        %% "json4s-jackson"  % Json4sVersion,
    "org.json4s"        %% "json4s-ext"      % Json4sVersion,
    "de.heikoseeberger" %% "akka-http-json4s" % "1.20.1"
  )
}