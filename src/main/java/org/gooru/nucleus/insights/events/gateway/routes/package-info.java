package org.gooru.nucleus.insights.events.gateway.routes;

/**
 * This package contains HTTP route specific machinery.
 * The routes are registered by RouteConfigurator. Each route configurator can configure multiple routes,
 * and provide their handlers. Routes could be clubbed by their functionality (e.g. auth) or by functionality
 * (e.g. Metrics).
 * These routes are registered with RouteConfiguration which is used by EventsWriteGatewayVerticle to configure all of
 * them. Currently, RouteConfiguration does not maintain a sequence except for the sequence in which RouteConfigurators
 * are registered.
 */