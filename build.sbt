scalaVersion := "3.3.3" // A Long Term Support version.

// enablePlugins(ScalaNativePlugin)

// set to Debug for compilation details (Info is default)
// logLevel := Level.Info

// import to add Scala Native options
// import scala.scalanative.build._

// defaults set with common options shown
// nativeConfig ~= { c =>
//   c.withLTO(LTO.none) // thin
//     .withMode(Mode.debug) // releaseFast
//     .withGC(GC.immix) // commix
// }

version := "0.3"

scalaVersion := "3.3.3"

scalacOptions += "@.scalacOptions.txt"

libraryDependencies ++= Seq(
  "org.scalatest"  %% "scalatest"  % "3.2.19"  % Test,
  "org.scalacheck" %% "scalacheck" % "1.18.0" % Test,
  "com.lihaoyi" %% "mainargs" % "0.7.5",
  "org.log4s" %% "log4s" % "1.10.0",
  "org.slf4j" % "slf4j-simple" % "2.0.16",
  "org.knowm.xchart" % "xchart" % "3.8.8",
)

enablePlugins(JavaAppPackaging)
coverageEnabled := true
