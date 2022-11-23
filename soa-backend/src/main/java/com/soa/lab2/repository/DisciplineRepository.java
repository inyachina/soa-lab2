package com.soa.lab2.repository;

import com.soa.lab2.model.Discipline;
import org.hibernate.exception.ConstraintViolationException;
import org.postgresql.util.PSQLException;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DisciplineRepository extends CrudRepository<Discipline, Integer> {
    List<Discipline> findAll();

    Discipline save(Discipline discipline);

    Optional<Discipline> getById(Integer id);

    Optional<Discipline> getByName(String id);

    void deleteById(Integer id);
}
