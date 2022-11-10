package com.soa.lab2.contoller;

import com.soa.lab2.dao.LabDTO;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.model.Discipline;
import com.soa.lab2.model.Lab;
import com.soa.lab2.service.impl.DisciplineServiceImpl;
import com.soa.lab2.service.impl.LabsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/labs")
public class LabsController {
    private LabsServiceImpl labsService;
    private DisciplineServiceImpl disciplineService;

    @Autowired
    public LabsController(LabsServiceImpl labsService, DisciplineServiceImpl disciplineService) {
        this.labsService = labsService;
        this.disciplineService = disciplineService;
    }


    @GetMapping
    private ResponseEntity getLabs() {
        List<Lab> labs = labsService.findAll();
        if (labs.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Collection is empty");
        else return ResponseEntity.ok().body(labs);
    }

    @PostMapping
    private ResponseEntity<Lab> saveLab(@RequestBody @Valid LabDTO labDTO) {
        Optional<Discipline> discipline = this.disciplineService.getByName(labDTO.getDisciplineName());
        if (discipline.isEmpty())
            throw new NoEntityException("The \"" + labDTO.getDisciplineName() + "\" discipline doesn't exist.");

        Lab lab = new Lab(labDTO, discipline.get());
        return ResponseEntity.ok().body(labsService.save(lab));
    }

    @GetMapping("/{id}")
    private ResponseEntity getLab(@PathVariable Integer id) {
        Optional<Lab> lab = this.labsService.findById(id);
        if (lab.isEmpty())
            throw new NoEntityException("Lab with such id doesn't exist");
        return ResponseEntity.ok().body(lab.get());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteLab(@PathVariable @Valid Integer id) {
        this.labsService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
