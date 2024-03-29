name := "bigdata-mx-2"

version := "0.1"
scalaVersion := "2.12.7"

lazy val root = Project(id = "root", base = file(".")) aggregate(
  streamingProducer,
  streamingConsumer,
  hdfs,
  sparkTask1,
  sparkTask2,
  sparkTask3,
  advancedStreaming,
  sparkTask3,
  sparkAdvanced
)

lazy val streamingProducer = Project(id = "streamingProducer", base = file("StreamingProducer"))
lazy val streamingConsumer = Project(id = "streamingConsumer", base = file("StreamingConsumer"))
lazy val hdfs = Project(id = "hdfs", base = file("HDFS"))
lazy val sparkTask1 = Project(id = "sparkTask1", base = file("SparkTask1"))
lazy val sparkTask2 = Project(id = "sparkTask2", base = file("SparkTask2"))
lazy val sparkTask3 = Project(id = "sparkTask3", base = file("SparkTask3"))
lazy val sparkAdvanced = Project(id = "sparkAdvanced", base = file("SparkAdvancedHomework"))
lazy val advancedStreaming = Project(id = "advancedStreaming", base = file("AdvancedSparkStreaming"))

coverageEnabled := true

scapegoatVersion in ThisBuild := "1.3.2"
scalaBinaryVersion in ThisBuild := "2.12"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
