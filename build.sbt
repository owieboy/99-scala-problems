name := "99 Scala Problems"
 
version := "1.0"
 
scalaVersion := "2.11.6"
 
libraryDependencies ++= Seq(
  //"org.scala-lang.modules" %% "scala-async"     % "0.9.2",
  //"org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.2",
 // "org.scala-lang.modules" %% "scala-xml"       % "1.0.2",
  //"org.scala-lang"          % "scala-reflect"   % "2.11.2",
  //"com.typesafe.akka"      %% "akka-actor"      % "2.3.4",
  //"com.typesafe.akka"      %% "akka-slf4j"      % "2.3.4",
  "ch.qos.logback"          % "logback-classic" % "1.1.2",
  "org.scalaz"             %% "scalaz-core"     % "7.1.0",
  "org.scalacheck"         %% "scalacheck"      % "1.11.5" % "test",
  "org.scalatest"          %% "scalatest"       % "2.2.1"  % "test",
  "org.specs2"             %% "specs2"          % "2.4"    % "test",
  // JUnit is used for some Java interop. examples. A driver for JUnit:
  "junit"                   % "junit-dep"       % "4.10"   % "test",
  "com.novocode"            % "junit-interface" % "0.10"   % "test"
)

