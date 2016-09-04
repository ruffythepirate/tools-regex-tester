
//libraryDependencies += "junit" % "junit" % "4.11" % "test->default"
//libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"


lazy val root = (project in file(".")).
  settings(
    name := "Regex Tester",
    version := "1.0",
    scalaVersion := "2.11.8"
  )

