import com.github.bigtoast.sbtthrift.ThriftPlugin

name := "UserProfile"

version := "0.1"

resolvers ++= Seq(
  "Typesafe Repository" at "http://repo.akka.io/snapshots/",
  "Typesafe Repository2" at "http://repo.typesafe.com/typesafe/releases/",
  "spray repo" at "http://repo.spray.io/"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.0"
  Seq(
    "org.apache.thrift" %  "libthrift"       % "0.8.0",
    "io.spray"          %  "spray-can"       % sprayV,
    "io.spray"          %  "spray-http"      % sprayV,
    "ch.qos.logback"    %  "logback-classic" % "1.0.3",
    "com.typesafe.akka" %% "akka-actor"      % akkaV,
    "com.typesafe.akka" %% "akka-slf4j"      % akkaV
  )
}


seq(ThriftPlugin.thriftSettings: _*)
