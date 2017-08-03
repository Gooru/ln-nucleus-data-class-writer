package org.gooru.nucleus.insights.events.gateway.startup;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonObject;

public interface Initializer {

  void initializeComponent(Vertx vertx, JsonObject config);

}
