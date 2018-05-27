name := "akka-http-benchs"

version := "0.1"

scalaVersion := "2.12.6"

//resolvers += Resolver.mavenLocal

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-http" % "10.1.1",
    "com.typesafe.akka" %% "akka-stream" % "2.5.12"
    //"io.spray" %% "spray-json" % "1.3.4"

  )
}
