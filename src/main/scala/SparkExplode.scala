import scala.io._
import org.apache.spark.sql.SparkSession
object SparkExplode{

  def main (args:Array[String]):Unit ={

    val spark = SparkSession.builder().appName("test").master("local[*]").getOrCreate()
    val data = Source.fromURL("https://randomuser.me/api/0.8/?results=5")

   // data.foreach(println)

    val rdds = spark.sparkContext.parallelize(List(data))
//
    println(rdds.count())

  }



}
