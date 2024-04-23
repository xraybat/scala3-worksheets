val scala3Version = "3.4.2"

lazy val worksheets = project
  .in(file("."))
  .settings(
    name := "scala3-worksheets",
    version := "0.1.0",

    scalaVersion := scala3Version,

    libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test"
  )
