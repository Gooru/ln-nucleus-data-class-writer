package org.gooru.nucleus.insights.events.gateway.routes.utils;

import org.gooru.nucleus.insights.events.gateway.responses.writers.ResponseWriterBuilder;
import org.slf4j.Logger;

import io.vertx.core.AsyncResult;
import io.vertx.core.eventbus.Message;
import io.vertx.ext.web.RoutingContext;

public class RouteResponseUtility {

    public void responseHandler(final RoutingContext routingContext, final AsyncResult<Message<Object>> reply,
        final Logger LOG) {
        if (reply.succeeded()) {
        	LOG.info("Success - Message Sent");
        	new ResponseWriterBuilder(routingContext, reply).build().writeResponse();
        } else {
            LOG.error("Not able to send message", reply.cause());
            routingContext.response().setStatusCode(500).end();
        }
    }
}
