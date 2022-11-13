package com.soa.lab2.contoller;

import com.soa.lab2.dao.DisciplineDTO;
import com.soa.lab2.dao.ExceptionResponse;
import com.soa.lab2.model.Discipline;
import com.soa.lab2.service.impl.DisciplineServiceImpl;
import org.postgresql.util.PSQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/disciplines")
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

    @PostMapping
    private ResponseEntity saveDiscipline(@RequestBody DisciplineDTO disciplineDTO) {
        Discipline discipline = this.disciplineService.save(new Discipline(disciplineDTO));
        return ResponseEntity.ok().body(discipline);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity deleteDiscipline(@PathVariable Integer id){
        this.disciplineService.deleteById(id);
        return ResponseEntity.ok().body(id);
    }

}
