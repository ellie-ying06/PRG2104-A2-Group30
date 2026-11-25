ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "PRG2104-A2",
    scalacOptions ++= Seq("-Wunused:all", "-deprecation", "-feature"),
    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )
