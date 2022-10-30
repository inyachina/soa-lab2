package com.soa.lab2.contoller;

import com.soa.lab2.model.Discipline;
import com.soa.lab2.service.impl.DisciplineServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplines")
@CrossOrigin
public class DisciplineController {
    private DisciplineServiceImpl disciplineService;

    @Autowired
    public DisciplineController(DisciplineServiceImpl disciplineService) {
        this.disciplineService = disciplineService;
    }

    @GetMapping
    private ResponseEntity getDisciplines() {
        List<Discipline> disciplines = disciplineService.findAll();
        if (disciplines.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Collection is empty");
        else return ResponseEntity.ok().body(disciplines);
    }
}
