ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

lazy val root = (project in file("."))
  .settings(
    name := "SaiTraining"
  )
// https://mvnrepository.com/artifact/org.apache.spark/spark-core
libraryDependencies += "org.apache.spark" %% "spark-core" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-sql
libraryDependencies += "org.apache.spark" %% "spark-sql" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming
libraryDependencies += "org.apache.spark" %% "spark-streaming" % "3.1.2"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kafka-0-10
libraryDependencies += "org.apache.spark" %% "spark-streaming-kafka-0-10" % "3.2.1"

// https://mvnrepository.com/artifact/org.apache.spark/spark-streaming-kinesis-asl
libraryDependencies += "org.apache.spark" %% "spark-streaming-kinesis-asl" % "3.2.0"

//// https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-kinesis
//libraryDependencies += "com.amazonaws" % "aws-java-sdk-kinesis" % "1.12.158"
//
//// https://mvnrepository.com/artifact/com.amazonaws/aws-java-sdk-s3
//libraryDependencies += "com.amazonaws" % "aws-java-sdk-s3" % "1.12.158"
//
//// https://mvnrepository.com/artifact/org.apache.hadoop/hadoop-aws
//libraryDependencies += "org.apache.hadoop" % "hadoop-aws" % "3.3.1"



