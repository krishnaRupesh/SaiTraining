import org.apache.spark.sql.SparkSession

object Training6DFReads extends App{

  val spark = SparkSession.builder().appName("train").master("local[*]").getOrCreate()

  val csvdf = spark.read.format("csv").option("header","true").load("")

  val csvdf2 = spark.read.format("csv").options(Map("header" -> "true")).load("")

  val parquetdf = spark.read.format("parquet").load("")




  val avrodf = spark.read.format("com.databricks.spark.avro").load("")

}
