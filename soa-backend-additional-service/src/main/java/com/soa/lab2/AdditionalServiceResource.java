package com.soa.lab2;


import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1")
public class AdditionalServiceResource {
    @EJB
    ServiceBean serviceBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "Da trash";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/disciplines/{discipline-id}/get-hardcore")
    public Response getHardcoreLabs(@PathParam("discipline-id") Integer id) {
        return serviceBean.getHardcoreLabsByDiscipline(id);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/labwork/{labwork-id}/difficulty/decrease/{steps-count}")
    public Response decreaseLabDifficulty(@PathParam("labwork-id") Integer id, @PathParam("steps-count") Integer steps) {
        return serviceBean.decreaseLabDifficulty(id, steps);
    }
}