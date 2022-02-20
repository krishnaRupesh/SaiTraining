import Training3Rdds.schema
import org.apache.spark.sql.SparkSession
import org.apache.spark.{SparkConf, SparkContext}

object Training4Rdds {

  def main(args:Array[String]):Unit = {

    val spark = SparkSession.builder().getOrCreate()
    import spark.implicits._
    val conf =  new SparkConf().setAppName("sparkrdds").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val data =  sc.textFile("")
    val mapsplit = data.map(x => x.split(","))
    val schemardd = mapsplit.map(x => schema(x(0).toInt,x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))
    val df = schemardd.toDF()
    df.createTempView("txns")
    val filtereddata = spark.sql("select * from txns where product = 'gym'")
    filtereddata.show()

  }

}
