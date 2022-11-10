package com.soa.lab2.service;

import com.soa.lab2.model.Lab;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface LabsService {

    List<Lab> findAll();

    Lab save(Lab entity);

    Optional<Lab> findById(Integer integer);

    void delete(Lab entity);

    void deleteById(Integer id);
}
