#!/bin/bash -x
 
PROJECT_NAME="99 Scala Problems"
SCALA_VERSION="2.11.6"
SCALATEST_VERSION="1.6.1"
MOCKITO_VERSION="1.8.5"
 
 
cat > build.sbt << EOF
name := "$PROJECT_NAME"
 
version := "1.0"
 
scalaVersion := "$SCALA_VERSION"
 
libraryDependencies ++= Seq(
  "org.scalaz"             %% "scalaz-core"     % "7.1.0",
  "org.scalacheck"         %% "scalacheck"      % "1.11.5" % "test",
  "org.scalatest"          %% "scalatest"       % "2.2.1"  % "test",
  "org.specs2"             %% "specs2"          % "2.4"    % "test",
  "junit"                   % "junit-dep"       % "4.10"   % "test",
  "com.novocode"            % "junit-interface" % "0.10"   % "test"
)

EOF
 
mkdir -p "src/main/scala"
mkdir -p "src/main/resources"
mkdir -p "src/test/scala"
mkdir -p "src/test/resources"
 
cat > .gitignore << EOF
target/
.DS_Store
.idea
.idea_modules
EOF
 
git add .gitignore
git add build.sbt
git commit -m 'Initialize SBT'
 
# You need to have the idea plugin in the global SBT's plugins/build.sbt
sbt update gen-idea
