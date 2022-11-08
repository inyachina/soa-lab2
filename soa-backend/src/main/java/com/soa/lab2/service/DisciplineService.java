package com.soa.lab2.service;

import com.soa.lab2.model.Discipline;

import java.util.List;

public interface DisciplineService {
    List<Discipline> findAll();

    Discipline save(Discipline discipline);

    Discipline getById(Integer id);

    void deleteById(Integer id);
}
