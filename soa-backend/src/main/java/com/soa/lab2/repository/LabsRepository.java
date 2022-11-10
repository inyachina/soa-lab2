package com.soa.lab2.repository;

import com.soa.lab2.model.Lab;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface LabsRepository extends CrudRepository<Lab, Integer> {

    List<Lab> findAll();

    Lab save(Lab entity);

    Optional<Lab> findById(Integer integer);

    void delete(Lab entity);

    void deleteById(Integer id);
}
