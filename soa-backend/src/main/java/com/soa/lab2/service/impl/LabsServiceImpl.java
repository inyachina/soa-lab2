package com.soa.lab2.service.impl;

import com.soa.lab2.dao.LabDTO;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;
import com.soa.lab2.repository.DisciplineRepository;
import com.soa.lab2.repository.LabsRepository;
import com.soa.lab2.service.LabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LabsServiceImpl implements LabsService {
    private LabsRepository labsRepository;
    private DisciplineRepository disciplineRepository;

    @Autowired
    public LabsServiceImpl(LabsRepository labsRepository, DisciplineRepository disciplineRepository) {
        this.labsRepository = labsRepository;
        this.disciplineRepository = disciplineRepository;
    }

    @Override
    public List<Lab> findAll() {
        return this.labsRepository.findAll();
    }

    @Override
    public List<Lab> findAll(Pageable pageable) {
        return this.labsRepository.findAll(pageable);
    }

    @Override
    public Lab save(Lab entity) {
        return labsRepository.save(entity);
    }

    @Override
    public Optional<Lab> findById(Integer id) {
        return labsRepository.findById(id);
    }

    @Override
    public long count() {
        return this.labsRepository.count();
    }

    @Override
    public void delete(Lab entity) {
        labsRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) {
        labsRepository.deleteById(id);
    }

    @Override
    public void deleteByDifficulty(Difficulty difficulty) {
        List<Lab> labs = this.labsRepository.findByDifficulty(difficulty);

        if (labs.isEmpty()) throw new NoEntityException("There is no a single lab with such difficulty");
        this.labsRepository.delete(labs.get(0));
    }

    @Override
    @Transactional
    public Lab update(Integer id, LabDTO newLab) {
        this.labsRepository.findById(id).map((lab -> {
            lab.setName(newLab.getName());
            lab.setX(newLab.getX());
            lab.setY(newLab.getY());
            lab.setDiscipline(this.disciplineRepository.getByName(newLab.getDisciplineName()).get());
            lab.setDifficulty(newLab.getDifficulty());
            lab.setMinimalPoint(newLab.getMinimalPoint());
            lab.setPersonalQualitiesMaximum(newLab.getPersonalQualitiesMaximum());
            return this.labsRepository.save(lab);
        })).orElseGet(() -> {
            Lab lab = new Lab(newLab, this.disciplineRepository.getByName(newLab.getDisciplineName()).get());
            newLab.setId(id);
            return this.labsRepository.save(lab);
        });
        return null;
    }
}
