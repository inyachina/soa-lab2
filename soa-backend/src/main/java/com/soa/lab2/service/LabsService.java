package com.soa.lab2.service;

import com.soa.lab2.data.dto.LabDTO;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;

import java.util.List;
import java.util.Optional;

public interface LabsService {
    List<Lab> findAll();

    public List<Lab> findAll(int page, int size, String sort, String filter);

    Lab save(LabDTO entity);

    Optional<Lab> findById(Integer integer);

    long count();

    void delete(Lab entity);

    void deleteById(Integer id);

    void deleteByDifficulty(Difficulty difficulty);

    Lab update(Integer id, LabDTO labDTO);
}
