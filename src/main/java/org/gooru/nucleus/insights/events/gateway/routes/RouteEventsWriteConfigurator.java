package org.gooru.nucleus.insights.events.gateway.routes;

import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;

/**
 * Created by mukul@gooru
 */
class RouteEventsWriteConfigurator implements RouteConfigurator {
    private EventBus eb = null;
    private long mbusTimeout;
    @Override
      public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        eb = vertx.eventBus();
        mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
        router.post(RouteConstants.WRITE_EVENT_ROUTE).handler(routingContext -> {
          DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000).addHeader(MessageConstants.MSG_HEADER_OP,
                  MessageConstants.MSG_OP_CREATE_EVENT);
          JsonObject request = new RouteRequestUtility().getBodyForMessage(routingContext);
          eb.send(MessagebusEndpoints.MBEP_RAW_EVENT, request, options);
          eb.send(MessagebusEndpoints.MBEP_ANALYTICS_WRITE, request, options);
          routingContext.response().setStatusCode(200).end();
        });
    
      } //End Configure Routes    
} // End Method
