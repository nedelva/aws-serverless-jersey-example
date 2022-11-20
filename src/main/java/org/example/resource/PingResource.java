package org.example.resource;


import org.example.beans.Greeter;

import java.util.Map;
import java.util.HashMap;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/ping")
public class PingResource {

    @Inject
    Greeter greeter;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.WILDCARD)
    public Response ping() {
        Map<String, String> pong = new HashMap<>();
        //pong.put("pong", "Hello, World!");
        pong.put("pong", greeter.greeting());
        return Response.status(200).entity(pong).build();
    }
}
