package com.soa.lab2;


import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/v1")
public class DisciplineResource {
    @EJB
    ServiceBean serviceBean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        return "helwwwwwl";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/disciplines/{discipline-id}/get-hardcore")
    public Response getHardcoreLabs(@PathParam("discipline-id") Integer id) {
        return serviceBean.getHardcoreLabsByDiscipline(id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/labwork/{labwork-id}/difficulty/decrease/{steps-count}")
    public Response decreaseLabDifficulty(@PathParam("labwork-id") Integer id, @PathParam("steps-count") Integer steps) {
        return serviceBean.decreaseLabDifficulty(id, steps);
    }
}