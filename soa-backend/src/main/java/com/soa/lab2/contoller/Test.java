package com.soa.lab2.contoller;

import com.soa.lab2.model.Difficulty;
import com.soa.lab2.repository.LabsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.Collectors;


@RequestMapping("/soa-backend-additional-service-1.0-SNAPSHOT/bars/api/v1/disciplines")
public class Test {
    @Autowired
    LabsRepository labsRepository;

    @GetMapping("/{discipline-id}/get-hardcore")
    public ResponseEntity getHardcoreLabsFromDiscipline(@PathVariable("discipline-id") Integer id) {
        return ResponseEntity.ok().body(labsRepository.findAll().stream().filter(lab -> lab.getDiscipline().getId() == id)
                .filter(lab -> lab.getDifficulty().equals(Difficulty.VERY_HARD))
                .limit(10).collect(Collectors.toList()));
    }
}
