import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.coreDefaultSettings ++ Seq(
    version := "1.0",
    scalacOptions ++= Seq("-deprecation", "-feature"),
    scalaVersion := "2.11.6",
	crossPaths := false,
	sbtVersion := "0.13.8"
  )
}

object MyBuild extends Build {
  import BuildSettings._

  lazy val root: Project = Project(
    "ex01",
    file("."),
    settings = buildSettings ++ Seq(
      libraryDependencies += "org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
	  libraryDependencies += "junit" % "junit" % "4.11" % "test",
	  libraryDependencies += "com.novocode" % "junit-interface" % "0.11" % "test->default",
	  
	  javacOptions ++= Seq("-source", "1.8", "-target", "1.8")
    )
  )
}