import org.apache.spark.{SparkConf, SparkContext}

object Training3Rdds {

  case class schema(
                   txnno:Int, // x(0)
                   txnDate:String,  // x(1)
                   custno:String,  // x(2)
                   amount:String,  // x(3)
                   category:String,  // x(4)
                   product:String,  // x(5)
                   city:String,  // x(6)
                   state:String,  // x(7)
                   spendby:String  // x(8)
                   )

  def main(args:Array[String]):Unit = {

    val conf =  new SparkConf().setAppName("sparkrdds").setMaster("local[*]")
    val sc = new SparkContext(conf)
    sc.setLogLevel("ERROR")
    val data =  sc.textFile("")
    val mapsplit = data.map(x => x.split(","))
    val schemardd = mapsplit.map(x => schema(x(0).toInt,x(1),x(2),x(3),x(4),x(5),x(6),x(7),x(8)))
    val filterdata = schemardd.filter(x => x.product.contains("Gym"))
    filterdata.foreach(println)

  }

}
