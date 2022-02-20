import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession


import org.apache.spark.streaming._

import org.apache.spark._
import org.apache.spark.sql._
import org.apache.spark.sql.functions._
import org.apache.spark.sql.types._
import org.apache.spark.streaming._
import org.apache.spark.streaming._

object TrainingStreeming {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("data").setMaster("local[*]").set("spark.driver.allowMultipleContexts", "true")
//    val sc = new SparkContext(conf)
//    sc.setLogLevel("Error")
//    val spark = SparkSession.builder().getOrCreate()
//    import spark.implicits._


    val ssc = new StreamingContext(conf, Seconds(3))


    val stream = ssc.textFileStream("file:///C:/Data/nifihttpout")


    stream.print()


    ssc.start()
    ssc.awaitTermination()

  }
}