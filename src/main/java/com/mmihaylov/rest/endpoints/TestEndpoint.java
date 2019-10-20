package com.mmihaylov.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/test")
public class TestEndpoint {


    @Path("/test-text")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response testText() {
        return Response.ok("The API works.").build();
    }

    @Path("/test-json")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response testJson() {
        Map<String, Object> bodyMap = new HashMap();
        bodyMap.put("msg", "The API works.");
        return Response.ok().entity(bodyMap).build();
    }
}
