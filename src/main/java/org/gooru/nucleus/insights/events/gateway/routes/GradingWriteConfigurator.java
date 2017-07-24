package org.gooru.nucleus.insights.events.gateway.routes;


import org.gooru.nucleus.insights.events.gateway.bootstrap.BootstrapVerticle;
import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;
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
 * 
 */
public class GradingWriteConfigurator implements RouteConfigurator {

	
    private static final Logger LOGGER = LoggerFactory.getLogger(GradingWriteConfigurator.class);

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        
//    	final EventBus eb = vertx.eventBus();
//        final long mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
//        
//        router.post(RouteConstants.STUDENT_GRADES_POST).handler(routingContext -> {
//            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
//                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_STUDENTS_GRADES_WRITE);
//            eb.send(MessagebusEndpoints.MBEP_RUBRIC_GRADING_WRITE, new RouteRequestUtility().getBodyForMessage(routingContext),
//                options);
//            
//        	routingContext.response().setStatusCode(200).end();
//        });
//    }
    	
        router.post(RouteConstants.STUDENT_GRADES_POST).handler(routingContext -> {
            JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
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
    }
    
    private void kafkaMessageProducer(JsonObject request) {
        if (request != null) {
          LOGGER.debug("***********************************************");
          LOGGER.debug("Dispatching: \n \n " + request.toString() + "\n");
          LOGGER.debug("***********************************************");
          String eventName = request.getString(ConfigConstants.EVENT_NAME);
          MessageDispatcher.getInstance().sendMessage2Kafka(eventName, request);
          LOGGER.info("Message dispatched successfully for event: {}", eventName);

        }
      }

}
