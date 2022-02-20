import org.apache.spark.storage.StorageLevel
import org.apache.spark.streaming.kinesis.KinesisInputDStream
import org.apache.spark.streaming.{Seconds, StreamingContext}
import com.amazonaws.services.kinesis.clientlibrary.lib.worker.InitialPositionInStream
import org.apache.spark._
import org.apache.spark.sql._

object TrainingStreemingKinesis {

  def b2s(a: Array[Byte]): String = new String(a)
  
  def main(args:Array[String]):Unit={


  val conf = new SparkConf().setAppName("ES").setMaster("local[*]").set("spark.driver.allowMultipleContexts","true")

  val sc = new SparkContext(conf)

  sc.setLogLevel("Error")

  val spark = SparkSession.builder.config(sc.getConf).getOrCreate()
  import spark.implicits._

  val ssc = new StreamingContext(sc,Seconds(2))

  val kinesisStream = KinesisInputDStream.builder
    .streamingContext(ssc)
    .endpointUrl("https://kinesis.ap-south-1.amazonaws.com")
  .regionName("ap-south-1")
  .streamName("rupesh__stream")
  .initialPositionInStream(InitialPositionInStream.LATEST)
  .checkpointAppName("rupeshconsumer")
  .checkpointInterval(Seconds(1))
  .storageLevel(StorageLevel.MEMORY_AND_DISK_2)
    .build()


//  val stream= KinesisUtils.createStream(
//    ssc,
//    "rupeshconsumer",
//    "rupesh__stream",
//    "https://kinesis.ap-south-1.amazonaws.com",
//    "ap-south-1",
//    InitialPositionInStream.LATEST,
//    Seconds(1),
//    StorageLevel.MEMORY_AND_DISK_2)

    val finalstream=kinesisStream.map(x=>b2s(x))
    finalstream.print()



  ssc.start()
  ssc.awaitTermination()


}
}