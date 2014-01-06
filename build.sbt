import com.twitter.sbt._

seq(CompileThriftScrooge.newSettings: _*)

name := "UserProfile"

version := "0.1"

scalaVersion := "2.9.2"

resolvers += "twitter-repo" at "http://maven.twttr.com"

libraryDependencies ++= {
  val finagleVersion = "6.6.2"
  Seq(
    "org.apache.thrift" % "libthrift" % "0.7.0" intransitive,
    "com.twitter" %% "scrooge-runtime" % "3.9.0",
    "com.twitter" %% "finagle-core" % finagleVersion,
    "com.twitter" %% "finagle-thrift" % finagleVersion,
    "com.twitter" %% "finagle-ostrich4" % finagleVersion
)}
