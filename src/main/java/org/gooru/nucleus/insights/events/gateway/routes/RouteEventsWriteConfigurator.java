package org.gooru.nucleus.insights.events.gateway.routes;

import org.gooru.nucleus.insights.events.gateway.bootstrap.BootstrapVerticle;
import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteResponseUtility;
import org.gooru.nucleus.insights.events.kafka.processors.MessageDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by mukul@gooru 
 * Modified by daniel
 */
class RouteEventsWriteConfigurator implements RouteConfigurator {
	
  private static final Logger LOGGER = LoggerFactory.getLogger(RouteEventsWriteConfigurator.class);
  //private EventBus eb = vertx.eventBus();
  private long mbusTimeout;
  
  @Override
  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
	 
	final EventBus eb = vertx.eventBus();
	
    router.post(RouteConstants.WRITE_EVENT_ROUTE).handler(routingContext -> {
      JsonObject request = new RouteRequestUtility().getJArrayBodyForMessage(routingContext); 
      LOGGER.debug("REQUEST ::: {} ", request);      
      JsonObject eventObj = request.getJsonObject(MessageConstants.MSG_HTTP_BODY);
      if (eventObj != null && !eventObj.isEmpty()) {
        kafkaMessageProducer(request.getJsonObject(MessageConstants.MSG_HTTP_BODY));
        routingContext.response().setStatusCode(200).end();
      } else {
        // Event Object is mandatory.
        routingContext.response().setStatusCode(400).end();
      }
    });
    
    router.post(RouteConstants.STUDENT_GRADES_POST).handler(routingContext -> {
        JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);        
        LOGGER.debug("REQUEST ::: {} ", request);        
        JsonObject eventObj = request.getJsonObject(MessageConstants.MSG_HTTP_BODY);
        if (eventObj != null && !eventObj.isEmpty()) {
          kafkaMessageProducer(request.getJsonObject(MessageConstants.MSG_HTTP_BODY));
          routingContext.response().setStatusCode(200).end();
        } else {
          // Event Object is mandatory.
          routingContext.response().setStatusCode(400).end();
        }
      });
    
    
    //Update Event - Teacher Override for Score    
    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
    router.put(RouteConstants.UPDATE_SCORE_ROUTE).handler(routingContext -> {
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_UPDATE_EVENT);
      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
      eb.send(MessagebusEndpoints.MBEP_ANALYTICS_UPDATE, request,
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
    });
    
    //Student Self Grading API for external Assessments 
    //eb = vertx.eventBus();
    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
    router.post(RouteConstants.STUDENT_SELF_GRADE_EXT_ASSESSMENT_POST).handler(routingContext -> {
      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
              MessageConstants.MSG_OP_SELF_GRADE_EXT_ASSESSMENT);
      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
      eb.send(MessagebusEndpoints.MBEP_ANALYTICS_SELF_GRADING_EXT_ASSESSMENT, request,
              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
    });

  } // End Configure Routes

  private void kafkaMessageProducer(JsonObject request) {
    if (request != null) {      
      LOGGER.debug("Dispatching message: \n \n " + request.toString() + "\n");      
      String eventName = request.getString(ConfigConstants.EVENT_NAME);
      MessageDispatcher.getInstance().sendMessage2Kafka(eventName, request);
      LOGGER.info("Message dispatched successfully for event: {}", eventName);

    }
  }

} // End Method
