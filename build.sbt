name := "akka-http-benchmark"

version := "0.1"

scalaVersion := "2.12.14"

//resolvers += Resolver.mavenLocal

libraryDependencies ++= {
  Seq(
      "com.typesafe.akka" %% "akka-http" % "10.2.7",
       "com.typesafe.akka" %% "akka-actor-typed" % "2.6.12",
      "com.typesafe.akka" %% "akka-stream" % "2.6.12"
    //"io.spray" %% "spray-json" % "1.3.4"

  )
}
