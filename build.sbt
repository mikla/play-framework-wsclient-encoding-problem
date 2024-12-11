name := """playframework-template-app"""
organization := "com.example"

ThisBuild / javacOptions ++= Seq("--release", "11")

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.15"

lazy val circeVersion = "0.14.2"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core" % circeVersion,
  "io.circe" %% "circe-generic" % circeVersion,
  "io.circe" %% "circe-parser" % circeVersion,
  "com.dripower" %% "play-circe" % "2814.2",
  "org.scalatestplus.play" %% "scalatestplus-play" % "5.1.0" % Test
)

libraryDependencies += guice
libraryDependencies += ws

