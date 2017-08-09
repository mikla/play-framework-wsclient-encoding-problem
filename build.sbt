name := """playframework-template-app"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

lazy val circeVersion = "0.8.0"

libraryDependencies += ws

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "play-circe" %% "play-circe" % "2.5-0.8.0",
  "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.0" % Test
)

