package com.soa.lab2.contoller;

import com.soa.lab2.dao.LabDTO;
import com.soa.lab2.model.Lab;
import com.soa.lab2.service.impl.LabsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/labs")
@CrossOrigin
public class LabsController {

    private LabsServiceImpl labsService;
    @Autowired
    public LabsController(LabsServiceImpl labsService) {
        this.labsService = labsService;
    }


    @ExceptionHandler
    public ResponseEntity handleException() {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
    }

    @GetMapping
    private ResponseEntity getLabs() {
        List<Lab> labs = labsService.findAll();
        if (labs.isEmpty()) return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Collection is empty");
        else return ResponseEntity.ok().body(labs);
    }

    @PostMapping
    private ResponseEntity<Lab> saveLab(@RequestBody LabDTO labDTO){
        Lab lab = new Lab(labDTO);
        return ResponseEntity.ok().body(labsService.save(lab));
    }
}
