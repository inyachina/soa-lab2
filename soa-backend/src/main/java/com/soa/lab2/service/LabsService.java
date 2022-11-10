package com.soa.lab2.service;

import com.soa.lab2.dao.LabDTO;
import com.soa.lab2.model.Lab;

import java.util.List;
import java.util.Optional;

public interface LabsService {

    List<Lab> findAll();

    Lab save(Lab entity);

    Optional<Lab> findById(Integer integer);

    void delete(Lab entity);

    void deleteById(Integer id);

    Lab update(Integer id, LabDTO labDTO);
}
