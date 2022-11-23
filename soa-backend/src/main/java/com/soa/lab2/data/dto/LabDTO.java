package com.soa.lab2.data.dto;

import com.soa.lab2.model.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LabDTO {

    @Nullable
    private Integer id;

    private String name;

    private double x;

    @Nullable
    private double y;

    @Nullable
    private LocalDate creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    private String disciplineName;
}
