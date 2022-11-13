//package com.soa.soabackenddisciplineservice;
//
//import com.soa.soabackenddisciplineservice.model.Difficulty;
//import com.soa.soabackenddisciplineservice.model.Lab;
//
//import javax.ejb.Stateless;
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Stateless
//public class DisciplineBean {
//    private final int PORT = 8080;
//    private final String HOST = "http://localhost:";
//    private final String URI = HOST + PORT + "/" + "api/v1";
//    private final String URI_LABS = URI + "/labs";
//    private final String URI_DISCIPLINES = URI + "/disciplines";
//    public Client client;
//
//
//    public Response getHardcoreLabsByDiscipline(Integer id) {
//        client = ClientBuilder.newClient();
//        List<Lab> labs = client.target(URI_LABS).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Lab>>() {
//        });
//        client.close();
//
//        return Response.ok()
//                .entity(labs.stream().filter(lab -> lab.getDiscipline().getId() == id)
//                        .filter(lab -> lab.getDifficulty().equals(Difficulty.VERY_HARD))
//                        .limit(10).collect(Collectors.toList()))
//                .build();
//    }
//}
