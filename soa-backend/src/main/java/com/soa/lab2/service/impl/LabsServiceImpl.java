package com.soa.lab2.service.impl;

import com.soa.lab2.model.Lab;
import com.soa.lab2.repository.LabsRepository;
import com.soa.lab2.service.LabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LabsServiceImpl implements LabsService {
    private LabsRepository labsRepository;

    @Autowired
    public LabsServiceImpl(LabsRepository labsRepository) {
        this.labsRepository = labsRepository;
    }

    @Override
    public List<Lab> findAll() {
        return this.labsRepository.findAll();
    }

    //    @Override
//    public List<Lab> findAll(Sort sort, Pageable pageable) {
//        return null;
//    }
    @Override
    public Lab save(Lab entity) {
        return labsRepository.save(entity);
    }

    @Override
    public Optional<Lab> findById(Integer id) {
        return labsRepository.findById(id);
    }

    @Override
    public void delete(Lab entity) {
        labsRepository.delete(entity);
    }

    @Override
    public void deleteById(Integer id) {
        labsRepository.deleteById(id);
    }
}
