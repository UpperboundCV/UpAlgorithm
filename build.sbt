name := "practice"

version := "0.1"

scalaVersion := "2.13.4"


ThisBuild / scalaVersion := "2.13.4"

lazy val practice = (project in file("."))
  .settings(
    name := "practice",
    libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
