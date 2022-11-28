package com.soa.lab2.data.dto;

import com.soa.lab2.model.Difficulty;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Builder
public class LabDTO {

    private Integer id;

    private String name;

    private double x;

    private double y;

    private Object creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    private String disciplineName;
}
