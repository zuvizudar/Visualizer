name := "visualize"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "org.scalafx" %% "scalafx" % "8.0.144-R12",
  "org.scalafx" %% "scalafxml-core-sfx8" % "0.3",
  "org.scala-lang.modules" %% "scala-java8-compat" % "0.8.0"
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
