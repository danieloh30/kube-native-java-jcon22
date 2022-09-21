package org.acme;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {

    @ConfigProperty(name = "name")
    String name;

    @ConfigProperty(name = "username")
    String username;

    @ConfigProperty(name = "password")
    String password;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/secret")
    public Map<String, String> secret() {
        HashMap<String, String> map = new HashMap<>();
        map.put("db.username", username);
        map.put("db.password", password);
        return map;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/greeting")
    public String greeting() {
        return "Hello from JCON, " + name;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from JCON with Kube Native Java using Quarkus!";
    }
}