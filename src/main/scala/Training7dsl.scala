import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.catalyst.dsl.expressions._
import org.apache.spark.sql.functions._

object Training7dsl extends App{

  val spark = SparkSession.builder().appName("train").master("local[*]").getOrCreate()

  val data =  spark.read.csv("")

  val data1 = data.filter(col("product") === "cash")
 // val data2 = data.filter($"product" === "cash") // used in some places for col. $ is from scala
 val data3 = data.filter(col("product") =!= "cash")
  val data4 = data.filter(col("product") === "cash" && col("catagory") === "Gym")
  val data5 = data.filter(col("product") like "%gym%")






}
