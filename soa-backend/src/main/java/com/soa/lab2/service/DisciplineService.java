package com.soa.lab2.service;

import com.soa.lab2.data.dto.DisciplineDTO;
import com.soa.lab2.model.Discipline;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DisciplineService {
    List<Discipline> findAll(Integer page, Integer size);

    Discipline save(DisciplineDTO disciplineDTO);

    void deleteById(Integer id);

    Object count();
}
