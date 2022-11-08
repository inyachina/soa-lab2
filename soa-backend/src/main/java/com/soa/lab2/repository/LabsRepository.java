package com.soa.lab2.repository;

import com.soa.lab2.model.Lab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LabsRepository extends CrudRepository<Lab, Integer> {

    List<Lab> findAll();

    Lab save(Lab entity);

    Lab getById(Integer id);

    void delete(Lab entity);

    void deleteById(Lab lab);
}
