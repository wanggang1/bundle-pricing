name := "bundle-pricing"

organization := "org.gwgs"

version := "1.0"

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  "org.scalatest"   %% "scalatest"   % "2.2.5"   % Test
)

resolvers += Classpaths.sbtPluginReleases

publishArtifact in Test := false

parallelExecution in Test := false
