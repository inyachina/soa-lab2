package com.soa.lab2.service.impl;

import com.soa.lab2.data.dto.LabDTO;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;
import com.soa.lab2.repository.DisciplineRepository;
import com.soa.lab2.repository.LabsRepository;
import com.soa.lab2.service.LabsService;
import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.ast.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import rsql.CustomRsqlVisitor;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    public List<Lab> findAll(int page, int size, String sort, String filter) {
        if (filter != null) {
            Node rootNode = new RSQLParser().parse(filter);
            Specification<Lab> spec = rootNode.accept(new CustomRsqlVisitor<>());
            if (sort != null)
                return this.labsRepository.findAll(spec, PageRequest.of(page, size, Sort.by(parseToSort(sort)))).getContent();
            else return this.labsRepository.findAll(spec, PageRequest.of(page, size)).getContent();
        } else if (sort != null){
            System.out.println("DDDDDDDDDDDDDDDDDDD");
            return this.labsRepository.findAll(PageRequest.of(page, size, Sort.by(parseToSort(sort)))).getContent();
        }

        return this.labsRepository.findAll(PageRequest.of(page, size)).getContent();
    }

    private List<Sort.Order> parseToSort(String sortRule) {
        return Stream.of(sortRule.split(";"))
                .map(x -> new Sort.Order(Sort.Direction.valueOf(x.split(",")[1].toUpperCase()), x.split(",")[0]))
                .collect(Collectors.toList());
    }

    @Override
    public Lab save(LabDTO labDTO) {
        return this.disciplineRepository.getByName(labDTO.getDisciplineName()).map((discipline) ->
                this.labsRepository.save(Lab.builder()
                        .name(labDTO.getName())
                        .x(labDTO.getX())
                        .y(labDTO.getY())
                        .discipline(discipline)
                        .difficulty(labDTO.getDifficulty())
                        .creationDate(LocalDate.now())
                        .minimalPoint(labDTO.getMinimalPoint())
                        .personalQualitiesMaximum(labDTO.getPersonalQualitiesMaximum())
                        .build())
        ).orElseThrow(() -> new NoEntityException("There is no such discipline"));
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
        return this.labsRepository.findById(id).map((lab ->
                        this.disciplineRepository.getByName(newLab.getDisciplineName()).map((discipline) ->
                                this.labsRepository.save(lab.toBuilder()
                                        .name(newLab.getName())
                                        .x(newLab.getX())
                                        .y(newLab.getY())
                                        .discipline(discipline)
                                        .difficulty(newLab.getDifficulty())
                                        .minimalPoint(newLab.getMinimalPoint())
                                        .personalQualitiesMaximum(newLab.getPersonalQualitiesMaximum())
                                        .build())
                        ).orElseThrow(() -> new NoEntityException("There is no such discipline"))))
                .orElseThrow(() -> new NoEntityException("Something went wrong, couldn't find this lab to update"));
    }
}
