name := "chapter-jvm-kafka"

version := "0.4"

scalaVersion := "2.12.8"

enablePlugins(JavaAppPackaging)
enablePlugins(DockerPlugin)

mainClass in Compile := Some("br.com.chapter.jvm.kafka.run.WebServer")

libraryDependencies ++= Seq(
  "org.apache.kafka" %% "kafka" % "2.2.0",
  "com.typesafe.akka" %% "akka-http"   % "10.1.8",
  "com.typesafe.akka" %% "akka-stream" % "2.5.19"
)
