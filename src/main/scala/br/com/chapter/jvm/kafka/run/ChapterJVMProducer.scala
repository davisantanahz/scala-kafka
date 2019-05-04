package br.com.chapter.jvm.kafka.run

import java.util.Properties
import org.apache.kafka.clients.producer._

object ChapterJVMProducer {

  def main(args: Array[String]): Unit = {

    val props:Properties = new Properties()
    props.put("bootstrap.servers","kafka:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("acks","all")
    val producer = new KafkaProducer[String, String](props)
    val topic = "test-topic"

    for (i <- 0 to 100) {
      val record = new ProducerRecord[String, String](topic, i.toString, "Enviando msg " + i)
      producer.send(record)
    }

  }

}
