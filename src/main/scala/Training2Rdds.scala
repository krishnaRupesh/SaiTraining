import org.apache.spark.{SparkConf, SparkContext}

object Training2Rdds {

  def main(args:Array[String]): Unit = {

    val conf =  new SparkConf().setAppName("sparkrdds").setMaster("local[*]")

    val sc = new SparkContext(conf)

    sc.setLogLevel("ERROR")

    val data =  sc.textFile("")
    val mapsplit = data.map(x => x.split(","))
    val filterdata = mapsplit.filter(x => x(5).contains("Gym"))

    val stringData = filterdata.map(x =>x.mkString("~"))
    stringData.foreach(println)

  }

}
