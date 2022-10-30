package com.soa.lab2.dao;

import com.soa.lab2.model.Coordinates;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Discipline;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LabDTO {

    @Nullable
    private Integer id;

    private String name;

    private Coordinates coordinates;

    private LocalDate creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    private Discipline discipline;
}
