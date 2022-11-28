package com.soa.lab2.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;


@Data
@ToString
@EqualsAndHashCode(of = {"id"})
public class Discipline {
    private int id;
    private String name;
    private int lectureHours;
    private int selfStudyHours;
}
