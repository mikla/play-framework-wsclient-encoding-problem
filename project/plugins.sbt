
// required in order to make sbt-native-packager & evo-sbt-docker work
libraryDependencySchemes += "org.scala-lang.modules" %% "scala-xml" % VersionScheme.Always

addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.8.19")
//addSbtPlugin("com.github.sbt" %% "sbt-native-packager" % "1.10.4")