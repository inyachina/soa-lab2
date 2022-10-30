package com.soa.lab2.repository;

import com.soa.lab2.model.Discipline;
import com.soa.lab2.model.Lab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
    List<Discipline> findAll();

}
