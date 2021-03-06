name := """akkademy-db"""

version := "1.0"

scalaVersion := "2.11.6"

javacOptions += "-Xlint:unchecked"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.3.11",
  "org.scala-lang.modules" % "scala-java8-compat_2.11" % "0.3.0",
  "com.typesafe.akka" %% "akka-testkit" % "2.3.11" % "test",
  "junit" % "junit" % "4.12" % "test",
  "com.novocode" % "junit-interface" % "0.11" % "test")
  
