package com.soa.lab2.contoller;


import com.soa.lab2.exception.EmptyCollectionException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;
import com.soa.lab2.service.impl.DisciplineServiceImpl;
import com.soa.lab2.service.impl.LabsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequestMapping("/api/v1/labs")
public class AdditionalLabsController {
    private LabsServiceImpl labsService;
    private DisciplineServiceImpl disciplineService;

    @Autowired
    public AdditionalLabsController(LabsServiceImpl labsService, DisciplineServiceImpl disciplineService) {
        this.labsService = labsService;
        this.disciplineService = disciplineService;
    }

    @GetMapping("/average/minimal_point")
    public ResponseEntity getAverageMinimalPoint() {
        List<Lab> labs = this.labsService.findAll();
        if (labs.isEmpty()) throw new EmptyCollectionException();
        return ResponseEntity.ok().body(labs.stream().mapToDouble(Lab::getMinimalPoint).average());
    }

    @DeleteMapping("/delete_by/difficulty")
    public void deleteByDifficulty(@RequestParam String difficulty) {
        this.labsService.deleteByDifficulty(Difficulty.valueOf(difficulty));
    }
}
