package com.soa.lab2.model;

import com.soa.lab2.dao.LabDTO;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.time.LocalDate;

@NonNull
@Data
@Entity
@Table(name = "lab")
@NoArgsConstructor
public class Lab {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "coordinates_id")
    private Coordinates coordinates;

    private LocalDate creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Lab(LabDTO labDTO){
        this.name = labDTO.getName();
        this.coordinates = labDTO.getCoordinates();
        this.creationDate = LocalDate.now();
        this.minimalPoint = labDTO.getMinimalPoint();
        this.personalQualitiesMaximum = labDTO.getPersonalQualitiesMaximum();
        this.difficulty = labDTO.getDifficulty();
        this.discipline = labDTO.getDiscipline();
    }
}
