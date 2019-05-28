package org.gooru.nucleus.insights.events.gateway.routes;

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
 * @author mukul@gooru
 */
public class RouteOAConfigurator implements RouteConfigurator {
	
	  private static final Logger LOGGER = LoggerFactory.getLogger(RouteOAConfigurator.class);
	  private long mbusTimeout;
	  
	  @Override
	  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {		 
		final EventBus eb = vertx.eventBus();
		
	    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
	    router.post(RouteConstants.OA_TASK_EVIDENCES_POST).handler(routingContext -> {
	      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
	              MessageConstants.MSG_OP_OA_EVIDENCES);
	      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
	      eb.send(MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, request,
	              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
	    });
	    
	    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
	    router.post(RouteConstants.OA_TASKS_STUDENT_SELF_GRADING_POST).handler(routingContext -> {
	      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
	              MessageConstants.MSG_OP_OA_TASK_SELF_GRADING);
	      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
	      eb.send(MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, request,
	              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
	    });
	    
	    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
	    router.post(RouteConstants.OA_COMPLETE_POST).handler(routingContext -> {
	      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
	              MessageConstants.MSG_OP_OA_DCA_EVENT);
	      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
	      eb.send(MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, request,
	              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
	    });
	    
	    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
	    router.post(RouteConstants.OA_TEACHER_GRADING_POST).handler(routingContext -> {
	      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
	              MessageConstants.MSG_OP_OA_TEACHER_GRADING);
	      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
	      eb.send(MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, request,
	              options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOGGER));      
	    });

	  }
	} 
