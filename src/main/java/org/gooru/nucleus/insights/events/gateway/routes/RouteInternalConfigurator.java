package org.gooru.nucleus.insights.events.gateway.routes;

import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * @author mukul@gooru 
 * 
 */
public class RouteInternalConfigurator implements RouteConfigurator {

	  private static final Logger LOGGER = LoggerFactory.getLogger(RouteInternalConfigurator.class);
	  private EventBus eb = null;
	  private long mbusTimeout;
	  
	  @Override
	  public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
	    eb = vertx.eventBus();
	    mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
	    router.post(RouteConstants.INTERNAL_OA_COMPLETE_POST).handler(routingContext -> {
	      DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
	              MessageConstants.MSG_OP_OA_COMPLETE_INTERNAL);
	      JsonObject request = new RouteRequestUtility().getJObjectBodyForMessage(routingContext);
	      eb.send(MessagebusEndpoints.MBEP_OFFLINE_ACTIVITY, request,
	              options);      
	      routingContext.response().setStatusCode(200).end();
	    });	  
	  }
}