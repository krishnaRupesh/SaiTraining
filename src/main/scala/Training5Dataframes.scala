import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.types.{StringType, StructField, StructType}

object Training5Dataframes extends App{

  val spark = SparkSession.builder().appName("traing").master("local[*]").getOrCreate()
  val sc = spark.sparkContext
  val data = sc.textFile("")
  data.foreach(println)
  val mapsplit = data.map(x => x.split(","))
  val structSchema = StructType(Array(
    StructField("txnno",StringType),StructField("category",StringType),StructField("product",StringType)))
  val rowrdds = mapsplit.map( x => Row(x(0),x(1),x(2)))
  val df = spark.createDataFrame(rowrdds,structSchema)
  df.createTempView("txns")
  val filtereddata = spark.sql("select * from txns where product = 'gym'")
  filtereddata.show()
}
