import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.types._

object TrainingStructuredStreaming extends App{

  val conf = new SparkConf().setAppName("ES").setMaster("local[*]").set("spark.driver.allowMultipleContexts","true")

  val sc = new SparkContext(conf)

  sc.setLogLevel("Error")

  val spark = SparkSession.builder.config(sc.getConf).getOrCreate()
  import spark.implicits._

  val weblogschema = StructType(Array(
    StructField("name", StringType, true),
    StructField("amount", StringType, true)));


  val df = spark.readStream.format("csv")
    .schema(weblogschema)
    .load("C:\\Data\\nifi\\data")


  df.writeStream.format("console")
    .option("checkpointLocation","file:///C:/datainputtss" )
    .start()
    .awaitTermination()

}
