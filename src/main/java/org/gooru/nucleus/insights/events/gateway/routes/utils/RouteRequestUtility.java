package org.gooru.nucleus.insights.events.gateway.routes.utils;

import java.util.Base64;
import java.util.List;
import java.util.Map;

import org.gooru.nucleus.insights.events.gateway.constants.HttpConstants;
import org.gooru.nucleus.insights.events.gateway.constants.MessageConstants;

import io.netty.handler.codec.http.QueryStringDecoder;
import io.vertx.core.http.HttpMethod;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

/**
 * Created by ashish on 30/12/15.
 */
public class RouteRequestUtility {

    /*
     * If the incoming request is POST or PUT, it is expected to have a payload
     * of JSON which is returned. In case of GET request, any query parameters
     * will be used to create a JSON body. Note that only query string is used
     * and not path matchers. In case of no query parameters send out empty Json
     * object, but don't send null
     */

    public JsonObject getJArrayBodyForMessage(RoutingContext routingContext) {
        JsonObject httpBody, result = new JsonObject();
        JsonArray httpArray = new JsonArray();
        String authorization = routingContext.request().getHeader(HttpConstants.HEADER_AUTH);
        String sessionToken = authorization != null ? authorization.substring(HttpConstants.TOKEN.length()).trim() : null;        
        if (routingContext.request().method().name().equals(HttpMethod.POST.name())
            || routingContext.request().method().name().equals(HttpMethod.PUT.name())) {
            //From Vertx's PoV FE is sending events as JsonArray and not as JsonObjects
        		httpArray = routingContext.getBodyAsJsonArray();
                httpBody = httpArray.getJsonObject(0);        		
        } else if (routingContext.request().method().name().equals(HttpMethod.GET.name())) {
            httpBody = new JsonObject();
            String uri = routingContext.request().query();
            
            if (uri != null) {
                QueryStringDecoder queryStringDecoder = new QueryStringDecoder(uri, false);
                Map<String, List<String>> prms = queryStringDecoder.parameters();
                if (!prms.isEmpty()) {
                    for (Map.Entry<String, List<String>> entry : prms.entrySet()) {
                        httpBody.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else {
            httpBody = new JsonObject();
        }
        result.put(MessageConstants.MSG_HTTP_BODY, httpBody);
        result.put(MessageConstants.MSG_HEADER_TOKEN, sessionToken);
        return result;
    }   
    
    //This is for TEST Purpose: Later Combine these two util methods 
    public JsonObject getJObjectBodyForMessage(RoutingContext routingContext) {
        JsonObject httpBody, result = new JsonObject();
        JsonArray httpArray = new JsonArray();
        String authorization = routingContext.request().getHeader(HttpConstants.HEADER_AUTH);
        String sessionToken = authorization != null ? authorization.substring(HttpConstants.TOKEN.length()).trim() : null;        
        if (routingContext.request().method().name().equals(HttpMethod.POST.name())
            || routingContext.request().method().name().equals(HttpMethod.PUT.name())) {                    		
                httpBody = routingContext.getBodyAsJson();
        } else if (routingContext.request().method().name().equals(HttpMethod.GET.name())) {
            httpBody = new JsonObject();
            String uri = routingContext.request().query();
            
            if (uri != null) {
                QueryStringDecoder queryStringDecoder = new QueryStringDecoder(uri, false);
                Map<String, List<String>> prms = queryStringDecoder.parameters();
                if (!prms.isEmpty()) {
                    for (Map.Entry<String, List<String>> entry : prms.entrySet()) {
                        httpBody.put(entry.getKey(), entry.getValue());
                    }
                }
            }
        } else {
            httpBody = new JsonObject();
        }
        httpBody.put("userIdFromSession", getUserIDFromToken(sessionToken));
        result.put(MessageConstants.MSG_HTTP_BODY, httpBody);
        result.put(MessageConstants.MSG_HEADER_TOKEN, sessionToken);
        return result;
    }   
    
    private static String getUserIDFromToken(String sessionToken) {
      try {
          String decoded = new String(Base64.getDecoder().decode(sessionToken));
          String[] decodedToken = decoded.split(":");
          try {
              Integer version = Integer.parseInt(decodedToken[0]);
              if (version == 2) {
                  return decodedToken[2];
              }
              
              return decodedToken[1];
              
          } catch (NumberFormatException nfe) {
              return decodedToken[1];
          }
      } catch (IllegalArgumentException e) {
          return null;
      }
  }

}