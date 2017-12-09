logLevel := Level.Warn

// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.5.15")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.11.2")

addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.0-M8")

addSbtPlugin("com.typesafe.sbt" % "sbt-multi-jvm" % "0.3.8")

addSbtPlugin("com.typesafe.sbt" % "sbt-aspectj" % "0.10.6")

addSbtPlugin("se.marcuslonnberg" % "sbt-docker" % "1.4.1")

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.8.2")
