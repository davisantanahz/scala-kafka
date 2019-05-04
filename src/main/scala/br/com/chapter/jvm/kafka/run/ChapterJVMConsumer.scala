package br.com.chapter.jvm.kafka.run

import java.util.Properties
import scala.collection.JavaConverters.{asJavaCollection}
import org.apache.kafka.clients.consumer.KafkaConsumer

object ChapterJVMConsumer {

  def main(args: Array[String]): Unit = {

    val topic = List("test-topic")

    val config = new Properties()

    config.put("bootstrap.servers", "kafka:9092")
    config.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    config.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
    config.put("group.id", "consumer-group")

    val consumer = new KafkaConsumer[String, String](config)
    consumer.subscribe(asJavaCollection(topic))

    while (true) {

      val record = consumer.poll(1000)
      record.forEach(println)

    }

  }

}
