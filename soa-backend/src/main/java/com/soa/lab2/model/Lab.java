package com.soa.lab2.model;

import com.soa.lab2.dao.LabDTO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

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

    private double x;

    @Nullable
    private double y;

    private LocalDate creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;

    public Lab(LabDTO labDTO, Discipline discipline) {
        this.name = labDTO.getName();
        this.x = labDTO.getX();
        this.y = labDTO.getY();
        this.creationDate = LocalDate.now();
        this.minimalPoint = labDTO.getMinimalPoint();
        this.personalQualitiesMaximum = labDTO.getPersonalQualitiesMaximum();
        this.difficulty = labDTO.getDifficulty();
        this.discipline = discipline;
    }
}
