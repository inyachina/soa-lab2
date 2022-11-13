package com.soa.lab2.service;

import com.soa.lab2.dao.LabDTO;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface LabsService {
    List<Lab> findAll();

    List<Lab> findAll(Pageable pageable);

    Lab save(Lab entity);

    Optional<Lab> findById(Integer integer);

    void delete(Lab entity);

    void deleteById(Integer id);

    void deleteByDifficulty(Difficulty difficulty);

    Lab update(Integer id, LabDTO labDTO);
}
