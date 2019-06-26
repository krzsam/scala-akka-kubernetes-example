import com.typesafe.sbt.packager.docker.DockerVersion

name := "scala-akka-kubernetes-example"

version := "0.1"

scalaVersion := "2.12.8"

// for sbt-assembly
resolvers += Resolver.url("https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/").
  withPatterns( Patterns( "https://repo.scala-sbt.org/scalasbt/sbt-plugin-releases/com.eed3si9n/[module]/scala_2.12/sbt_1.0/[revision]/ivys/ivy.xml" ) )

libraryDependencies += "org.slf4j" % "slf4j-api" % "1.7.25"
libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.26"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.23"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.5.23"
libraryDependencies += "com.typesafe.akka" %% "akka-http"  % "10.1.8"

enablePlugins(DockerPlugin,UniversalPlugin,JavaAppPackaging)

// Docker image settings
dockerExposedPorts in Docker ++= Seq(8080)
dockerVersion in Docker := Some(DockerVersion(18, 9, 6, Some("ce")))
mappings in Docker := (mappings in Docker).value
dockerUpdateLatest in Docker := true
dockerBaseImage in Docker := "openjdk"
