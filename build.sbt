import com.github.bigtoast.sbtthrift.ThriftPlugin

name := "UserProfile"

version := "0.1"


seq(ThriftPlugin.thriftSettings: _*)


libraryDependencies += "org.apache.thrift" % "libthrift" % "0.8.0"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.2"
