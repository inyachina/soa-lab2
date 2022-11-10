package com.soa.lab2.service.impl;

import com.soa.lab2.model.Discipline;
import com.soa.lab2.repository.DisciplineRepository;
import com.soa.lab2.service.DisciplineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplineServiceImpl implements DisciplineService {
    private DisciplineRepository disciplineRepository;

    @Autowired
    public DisciplineServiceImpl(DisciplineRepository disciplineRepository) {
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<Discipline> findAll() {
        return disciplineRepository.findAll();
    }

    @Override
    public Discipline save(Discipline discipline) {
        return this.disciplineRepository.save(discipline);
    }

    @Override
    public Optional<Discipline> getById(Integer id) {
        return this.disciplineRepository.getById(id);
    }

    @Override
    public Optional<Discipline> getByName(String name) {
        return this.disciplineRepository.getByName(name);
    }

    @Override
    public void deleteById(Integer id) {
        this.disciplineRepository.deleteById(id);
    }

}
