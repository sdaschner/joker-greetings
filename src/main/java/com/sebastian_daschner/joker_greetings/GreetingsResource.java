package com.sebastian_daschner.joker_greetings;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("greetings")
public class GreetingsResource {

    @Inject
    Greetings greetings;

    @GET
    @Path("{name}")
    public JsonObject calculateGreeting(@PathParam("name") String name) {
        String greeting = greetings.calculateGreeting(name);

        return Json.createObjectBuilder()
                .add("greeting", greeting)
                .build();
    }

}
