import com.github.bigtoast.sbtthrift.ThriftPlugin

name := "UserProfile"

version := "0.1"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.akka.io/snapshots/",
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.3-SNAPSHOT"
  val sprayV = "1.1.0"
  Seq(
    "org.apache.thrift" %  "libthrift"     % "0.8.0",
    "io.spray"          %  "spray-can"     % sprayV,
    "io.spray"          %  "spray-http"    % sprayV,
    "org.slf4j"         %  "slf4j-log4j12" % "1.7.2",
    "com.typesafe.akka" %% "akka-actor"    % akkaV
  )
}


seq(ThriftPlugin.thriftSettings: _*)
