package com.soa.lab2.model;

import lombok.*;

import java.time.LocalDate;


@Data
@ToString
@EqualsAndHashCode(of = {"id"})
public class Lab {

    private Integer id;

    private String name;

    private double x;

    private double y;

    private Object creationDate;

    private int minimalPoint;

    private float personalQualitiesMaximum;

    private Difficulty difficulty;

    private Discipline discipline;
}
