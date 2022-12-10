package com.soa.lab2;

import com.soa.lab2.data.dto.LabDTO;
import com.soa.lab2.exception.DecreaseDifficultyException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Discipline;
import com.soa.lab2.model.Lab;

import javax.ejb.Stateless;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class ServiceBean {
    private final String HOST = "https://localhost:41571/lab2-0.0.1-SNAPSHOT/";
    private final String URI = HOST + "/" + "api/v1";
    private final String URI_LABS = URI + "/labs";
    private final String URI_DISCIPLINES = URI + "/disciplines";
    public Client client;


    public Response getHardcoreLabsByDiscipline(Integer id) {
        client = ClientBuilder.newClient();
        List<Lab> labs = client.target(URI_LABS + "/all").request(MediaType.APPLICATION_JSON)
                .get(new GenericType<List<Lab>>() {
                });
        Discipline discipline = client.target(URI_DISCIPLINES + "/" + id).request(MediaType.APPLICATION_JSON)
                .get(new GenericType<Discipline>() {
                });
        client.close();

        if (discipline == null) throw new NotFoundException("There is no such discipline");
        if (labs.isEmpty()) return Response.ok().build();
        return Response.ok()
                .entity(labs.stream().filter(lab -> lab.getDiscipline().getId() == id)
                        .filter(lab -> lab.getDifficulty().equals(Difficulty.VERY_HARD))
                        .limit(10).collect(Collectors.toList()))
                .build();
    }

    public Response decreaseLabDifficulty(Integer labId, Integer steps) {
        client = ClientBuilder.newClient();
        Lab lab = client.target(URI_LABS + "/" + labId).request(MediaType.APPLICATION_JSON).get(new GenericType<Lab>() {
        });
        if (lab == null) throw new NotFoundException("Such lab doesn't exists");
        Integer currentLevel = lab.getDifficulty().getLevel();

        if (currentLevel - steps < 0) throw new DecreaseDifficultyException("Impossible to decrease on this step");

        lab.setDifficulty(Difficulty.getDifficultyByLevel(currentLevel - steps));
        client.target(URI_LABS + "/" + lab.getId()).request(MediaType.APPLICATION_JSON).put(Entity.entity(
                LabDTO.builder()
                        .id(lab.getId())
                        .name(lab.getName())
                        .creationDate(lab.getCreationDate())
                        .x(lab.getX())
                        .y(lab.getY())
                        .minimalPoint(lab.getMinimalPoint())
                        .personalQualitiesMaximum(lab.getPersonalQualitiesMaximum())
                        .disciplineName(lab.getDiscipline().getName())
                        .difficulty(lab.getDifficulty())
                        .build()
                , MediaType.APPLICATION_JSON));
        client.close();
        return Response.ok()
                .entity(lab)
                .build();
    }


}
