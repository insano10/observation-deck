import com.earldouglas.xwp.JettyPlugin
import org.scalatra.sbt._
import sbt.Keys._
import sbt._

object GithubActivityMonitorBuild extends Build {
  val Organization = "com.insano10"
  val Name = "Github Activity Monitor"
  val Version = "0.1.0-SNAPSHOT"
  val ScalaVersion = "2.11.8"
  val ScalatraVersion = "2.4.1"
  val DispatchVersion = "0.11.3"

  lazy val project = Project (
    "github-activity-monitor",
    file("."),
    settings = ScalatraPlugin.scalatraSettings  ++ Seq(
      organization := Organization,
      name := Name,
      version := Version,
      scalaVersion := ScalaVersion,
      resolvers += Classpaths.typesafeReleases,
      resolvers += "Scalaz Bintray Repo" at "http://dl.bintray.com/scalaz/releases",
      libraryDependencies ++= Seq(
        "org.kohsuke" % "github-api" % "1.77",
        "com.typesafe" % "config" % "1.2.1",
        "com.typesafe.scala-logging" % "scala-logging_2.11" % "3.4.0",
        "com.github.cb372" %% "scalacache-guava" % "0.9.1",
        "org.scalatra" %% "scalatra" % ScalatraVersion,
        "org.scalatra" %% "scalatra-scalate" % ScalatraVersion,
        "org.scalatra" %% "scalatra-json" % ScalatraVersion,
        "org.json4s"   %% "json4s-jackson" % "3.3.0",
        "com.typesafe.akka" %% "akka-actor" % "2.4.9",
        "net.databinder.dispatch" %% "dispatch-core" % DispatchVersion,
        "net.databinder.dispatch" %% "dispatch-json4s-native" % DispatchVersion,
        "org.scalatra" %% "scalatra-specs2" % ScalatraVersion % "test",
        "ch.qos.logback" % "logback-classic" % "1.1.5" % "runtime",
        "org.eclipse.jetty" % "jetty-webapp" % "9.2.15.v20160210" % "container;compile",
        "javax.servlet" % "javax.servlet-api" % "3.1.0" % "provided"
      )
    )
  ).enablePlugins(JettyPlugin)
}