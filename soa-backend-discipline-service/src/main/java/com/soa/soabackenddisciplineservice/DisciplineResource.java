//package com.soa.soabackenddisciplineservice;
//
//import javax.ejb.EJB;
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/disciplines")
//public class DisciplineResource {
//    @EJB
//    DisciplineBean disciplineBean;
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Path("/discipline/{discipline-id}/get-hardcore")
//    public Response getHardcoreDisciplines(@PathParam("discipline-id") Integer id) {
//        return disciplineBean.getHardcoreLabsByDiscipline(id);
//    }
//}

package com.soa.soabackenddisciplineservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/hello-world")
public class DisciplineResource {
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}