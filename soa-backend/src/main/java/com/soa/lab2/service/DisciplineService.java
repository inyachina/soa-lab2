package com.soa.lab2.service;

import com.soa.lab2.model.Discipline;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    List<Discipline> findAll();

    Discipline save(Discipline discipline);

    Optional<Discipline> getById(Integer id);

    Optional<Discipline> getByName(String id);

    void deleteById(Integer id);
}
