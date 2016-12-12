package org.gooru.nucleus.insights.events.gateway.bootstrap;

import org.gooru.nucleus.insights.events.gateway.constants.ConfigConstants;
import org.gooru.nucleus.insights.events.gateway.routes.RouteConfiguration;
import org.gooru.nucleus.insights.events.gateway.routes.RouteConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.ext.web.Router;

/**
 * Created by ashish on 4/12/15.
 * 
 * Starts the HTTP gateway for nucleus.
 * <p>
 * This class is the HTTP gateway for nucleus. It starts HTTP server on port
 * specified in configuration file, registers the routes and corresponding
 * handlers.
 */
public class EventsWriteGatewayVerticle extends AbstractVerticle {

    private static final Logger LOG = LoggerFactory.getLogger(EventsWriteGatewayVerticle.class);

    @Override
    public void start(Future<Void> voidFuture) throws Exception {

        LOG.info("Starting EventsWriteGatewayVerticle...");
        final HttpServer httpServer = vertx.createHttpServer();

        final Router router = Router.router(vertx);

        // Register the routes
        RouteConfiguration rc = new RouteConfiguration();
        for (RouteConfigurator configurator : rc) {
            configurator.configureRoutes(vertx, router, config());
        }

        // If the port is not present in configuration then we end up
        // throwing as we are casting it to int. This is what we want.
        final int port = config().getInteger(ConfigConstants.HTTP_PORT);
        LOG.info("Http server starting on port {}", port);
        httpServer.requestHandler(router::accept).listen(port, result -> {
            if (result.succeeded()) {
                LOG.info("HTTP Server started successfully");
                voidFuture.complete();
            } else {
                // Can't do much here, Need to Abort. However, trying to exit
                // may have us blocked on other threads that we may have
                // spawned, so we need to use
                // brute force here
                LOG.error("Not able to start HTTP Server", result.cause());
                voidFuture.fail(result.cause());
                Runtime.getRuntime().halt(1);
            }
        });

    }

}
