package org.gooru.nucleus.insights.events.kafka.processors;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.util.internal.StringUtil;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;

public class KafkaMessageConsumer implements Runnable {

  private static final Logger LOGGER = LoggerFactory.getLogger(KafkaMessageConsumer.class);
  private KafkaConsumer<String, String> consumer = null;
  private EventBus eb = null;
  private JsonObject config = null;
  private long mbusTimeout;
  private DeliveryOptions options;
  
  public KafkaMessageConsumer(KafkaConsumer<String, String> consumer, EventBus eb, JsonObject config) {
    this.consumer = consumer;
    this.eb = eb;
    this.config = config;
    this.mbusTimeout = this.config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
    this.options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
            MessageConstants.MSG_OP_CREATE_EVENT);

  }

  @Override
  public void run() {
    while (true) {
      ConsumerRecords<String, String> records = consumer.poll(200);
      for (ConsumerRecord<String, String> record : records) {
        switch (record.topic().split(ConfigConstants.HYPHEN)[0]) {
        case ConfigConstants.KAFKA_EVENTLOGS_TOPIC:
          sendMessage(record.value());
          break;
        case ConfigConstants.KAFKA_TEST_TOPIC:
          LOGGER.info("Test Kafka Consumer : {}", record.value());
          break;
        case ConfigConstants.KAFKA_XAPITRANSFORMER_TOPIC:
          LOGGER.debug("xAPI Event : {}", record.value());
          LOGGER.warn("We don't have processor to process xAPI event");
          break;
        default:
          //FIXME: Revisit this logic.
          LOGGER.warn("Assume that message is coming from unknown topic. Send to handlers anyway");
          sendMessage(record.value());
        }
      }
    }
  }
  //Send messages to handlers via event bus
  private void sendMessage(String record) {
    if (!StringUtil.isNullOrEmpty(record)) {
      JsonObject eventObject = null;
      try {
        eventObject = new JsonObject(record);
      } catch (Exception e) {
        LOGGER.warn("Kafka Message should be JsonObject");
      }
      if (eventObject != null) {
        JsonObject result = new JsonObject();
        result.put(MessageConstants.MSG_HTTP_BODY, eventObject);
        LOGGER.info("Message : {}", result);
        eb.send(MessagebusEndpoints.MBEP_RAW_EVENT, result, options);
        eb.send(MessagebusEndpoints.MBEP_ANALYTICS_WRITE, result, options);
        //Rubrics Grading
        eb.send(MessagebusEndpoints.MBEP_RUBRIC_GRADING_WRITE, result, options);
      }
    } else {
      LOGGER.warn("NULL or Empty message can not be processed...");
    }
  }
}
