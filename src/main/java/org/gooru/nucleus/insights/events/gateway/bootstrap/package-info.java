package org.gooru.nucleus.insights.events.gateway.bootstrap;

/**
 * This package contains the required machinery to boot up the system.
 * Currently this package contains EventsWriteGatewayVerticle which spawns off an http
 * server to listen to various incoming requests.
 * The requests are first authorized. For authorization, they are sent to
 * a registered end point on message bus. If the auth is successful, then
 * the request is passed on to the actual handler on message bus.
 * The resulting response is returned back to caller.
 */