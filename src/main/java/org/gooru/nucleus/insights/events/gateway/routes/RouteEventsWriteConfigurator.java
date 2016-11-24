package org.gooru.nucleus.insights.events.gateway.routes;

import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessagebusEndpoints;
import org.gooru.nucleus.insights.events.gateway.constants.RouteConstants;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteRequestUtility;
import org.gooru.nucleus.insights.events.gateway.routes.utils.RouteResponseUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by mukul@gooru
 */
class RouteEventsWriteConfigurator implements RouteConfigurator {
    private EventBus eb = null;
    private long mbusTimeout;
    private static final Logger LOG = LoggerFactory.getLogger("org.gooru.nucleus.insights.events.gateway.bootstrap.EventsWriteGatewayVerticle");

    @Override
    public void configureRoutes(Vertx vertx, Router router, JsonObject config) {
        eb = vertx.eventBus();
        mbusTimeout = config.getLong(ConfigConstants.MBUS_TIMEOUT, 30L) * 1000;
        //router.post(RouteConstants.EP_RESOURCE_COPY).handler(this::resourceCopy); 
                
        router.post(RouteConstants.WRITE_EVENT_ROUTE).handler(routingContext -> {
            DeliveryOptions options = new DeliveryOptions().setSendTimeout(mbusTimeout * 1000)
                .addHeader(MessageConstants.MSG_HEADER_OP, MessageConstants.MSG_OP_PROCESS_PLAY_EVENTS);
            eb.send(MessagebusEndpoints.MBEP_ANALYTICS_WRITE, new RouteRequestUtility().getBodyForMessage(routingContext),
                options, reply -> new RouteResponseUtility().responseHandler(routingContext, reply, LOG));
        });
    }
    
}
