package com.soa.lab2.model;

import lombok.Data;
import lombok.NonNull;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Data
@Entity
@NonNull

@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true)
    private String name;
    @Nullable
    private int lectureHours;
    private int selfStudyHours;
}
