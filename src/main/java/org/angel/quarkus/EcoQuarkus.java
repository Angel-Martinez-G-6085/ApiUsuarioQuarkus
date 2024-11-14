package org.angel.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/saludar")
public class EcoQuarkus {
    @GET
    public String hello( String name){
        return "hola" + name;
    }

    @GET
    @Path("/noches")
    public String noches(){
        return "buenas noches";
    }
}
