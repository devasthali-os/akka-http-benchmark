name := "akka-http-benchs"

version := "0.1"

scalaVersion := "2.12.4"

//resolvers += Resolver.mavenLocal

libraryDependencies ++= {
  Seq(
    "com.typesafe.akka" %% "akka-http" % "10.0.11",
   // "com.typesafe.akka" %% "akka-actor" % "2.5.9",
    //"io.spray" %% "spray-json" % "1.3.4"

  )
}
