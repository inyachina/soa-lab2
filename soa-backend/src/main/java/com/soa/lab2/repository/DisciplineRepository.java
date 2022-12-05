package com.soa.lab2.repository;

import com.soa.lab2.model.Discipline;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
    List<Discipline> findAll();

    List<Discipline> findAll(Pageable pageable);

    Discipline save(Discipline discipline);

    Optional<Discipline> getById(Integer id);

    Optional<Discipline> getByName(String id);

    long count();

    void deleteById(Integer id);
}
