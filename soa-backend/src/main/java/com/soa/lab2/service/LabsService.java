package com.soa.lab2.service;

import com.soa.lab2.model.Lab;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface LabsService {

    List<Lab> findAll(Sort sort, Pageable pageable);

    Lab save(Lab entity);

    Lab getById(Integer id);

    void delete(Lab entity);

    void deleteById(Lab lab);
}
