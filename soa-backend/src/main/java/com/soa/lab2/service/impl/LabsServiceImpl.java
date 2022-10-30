package com.soa.lab2.service.impl;

import com.soa.lab2.model.Lab;
import com.soa.lab2.repository.LabsRepository;
import com.soa.lab2.service.LabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabsServiceImpl implements LabsService {
    private LabsRepository labsRepository;

    @Autowired
    public LabsServiceImpl(LabsRepository labsRepository) {
        this.labsRepository = labsRepository;
    }

    @Override
    public List<Lab> findAll(Sort sort, Pageable pageable) {
        return null;
    }
    public List<Lab> findAll() {
        return null;
    }
    @Override
    public Lab save(Lab entity) {
        return labsRepository.save(entity);
    }

    @Override
    public Lab getById(Integer id) {
        return labsRepository.getById(id);
    }

    @Override
    public void delete(Lab entity) {
        labsRepository.delete(entity);
    }

    @Override
    public void deleteById(Lab lab) {
        labsRepository.deleteById(lab);
    }
}
