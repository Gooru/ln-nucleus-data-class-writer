package org.gooru.nucleus.insights.events.gateway.routes;

import org.gooru.nucleus.insights.events.gateway.bootstrap.BootstrapVerticle;
import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.insights.events.kafka.processors.MessageDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by mukul@gooru Modified by daniel
 */
class RouteEventsWriteConfigurator implements RouteConfigurator {
  private static final Logger LOGGER = LoggerFactory.getLogger(BootstrapVerticle.class);

  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
    router.post(RouteConstants.WRITE_EVENT_ROUTE).handler(routingContext -> {
      JsonObject request = new RouteRequestUtility().getBodyForMessage(routingContext);
      LOGGER.debug("***********************************************");
      LOGGER.debug("REQUEST ::: {} ", request);
      LOGGER.debug("***********************************************");
      JsonObject eventObj = request.getJsonObject(MessageConstants.MSG_HTTP_BODY);
      if (eventObj != null && !eventObj.isEmpty()) {
        kafkaMessageProducer(request.getJsonObject(MessageConstants.MSG_HTTP_BODY));
        routingContext.response().setStatusCode(200).end();
      } else {
        // Event Object is mandatory.
        routingContext.response().setStatusCode(400).end();
      }
    });

  } // End Configure Routes

  private void kafkaMessageProducer(JsonObject request) {
    if (request != null) {
      LOGGER.debug("***********************************************");
      LOGGER.debug("Now dispatch message: \n \n " + request.toString() + "\n");
      LOGGER.debug("***********************************************");
      String eventName = request.getString(ConfigConstants.EVENT_NAME);
      MessageDispatcher.getInstance().sendMessage2Kafka(eventName, request);
      LOGGER.info("Message dispatched successfully for event: {}", eventName);

    }
  }

} // End Method
