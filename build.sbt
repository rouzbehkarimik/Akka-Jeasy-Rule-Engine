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
    "com.internetitem" % "logback-elasticsearch-appender" % "1.6",
    "ch.qos.logback" % "logback-core" % "1.2.3",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.slf4j" % "slf4j-api" % "1.7.25"


)



aspectjSettings
javaOptions <++= AspectjKeys.weaverOptions in Aspectj
fork in run := true


mainClass in (Compile, run) := Some("ir.techstorm.ruleengine.example.Main")