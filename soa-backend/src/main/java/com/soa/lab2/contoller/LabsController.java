package com.soa.lab2.contoller;

import com.soa.lab2.data.dto.LabDTO;
import com.soa.lab2.exception.EmptyCollectionException;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.model.Lab;
import com.soa.lab2.service.impl.DisciplineServiceImpl;
import com.soa.lab2.service.impl.LabsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Validated
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
    private ResponseEntity getLabs(@RequestParam @DefaultValue(value = "0") Integer page,
                                   @RequestParam @DefaultValue(value = "15") Integer size,
                                   @RequestParam @Nullable String sort,
                                   @RequestParam @Nullable String filter) {
        List<Lab> labs = labsService.findAll(page, size, sort, filter);
        if (labs.isEmpty())
            throw new EmptyCollectionException();
        else return ResponseEntity.ok().body(labs);
    }

    @GetMapping("/all")
    private ResponseEntity getLabs() {
        List<Lab> labs = labsService.findAll();
        if (labs.isEmpty())
            throw new EmptyCollectionException();
        else return ResponseEntity.ok().body(labs);
    }

    @GetMapping("/amount")
    private ResponseEntity getLabsAmount() {
        return ResponseEntity.ok().body(this.labsService.count());
    }

    @PostMapping
    private ResponseEntity<Lab> saveLab(@RequestBody LabDTO labDTO) {
        return ResponseEntity.ok().body(this.labsService.save(labDTO));
    }

    @GetMapping("/{id}")
    private ResponseEntity getLab(@PathVariable Integer id) {
        Optional<Lab> lab = this.labsService.findById(id);
        if (lab.isEmpty())
            throw new NoEntityException("Lab with such id doesn't exist");
        return ResponseEntity.ok().body(lab.get());
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteLab(@PathVariable Integer id) {
        this.labsService.deleteById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    private ResponseEntity updateLab(@PathVariable Integer id, @RequestBody LabDTO labDTO) {
        return ResponseEntity.ok().body(this.labsService.update(id, labDTO));
    }
}
