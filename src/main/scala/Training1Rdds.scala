import org.apache.spark.{SparkConf, SparkContext}

object Training1Rdds {

  def main (args:Array[String]):Unit = {

    val conf =  new SparkConf().setAppName("sparkrdds").setMaster("local[*]")

    val sc =  new SparkContext(conf)
    sc.setLogLevel("ERROR")

    val data =  sc.textFile("")
    val gymdata = data.filter(x => x.contains("Gym"))
    gymdata.foreach(println)

  }

}
