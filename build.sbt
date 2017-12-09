import com.typesafe.sbt.SbtAspectj.AspectjKeys

name := "Tech Storm Rule Engine"
version := "1.0"
scalaVersion := "2.11.11"
val akkaVersion = "2.5.3"
val jeasyVersion = "3.0.0"

  libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-persistence" % akkaVersion,
    "org.jeasy" % "easy-rules-core" % jeasyVersion,
    "org.jeasy" % "easy-rules" % jeasyVersion,
    "org.aspectj" % "aspectjweaver" % "1.8.10",
    "ch.qos.logback" % "logback-classic" % "1.2.3"



)



aspectjSettings
javaOptions <++= AspectjKeys.weaverOptions in Aspectj
fork in run := true