package com.soa.lab2.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.soa.lab2.data.dto.LabDTO;
import com.soa.lab2.data.sort_filter.OrderRule;
import com.soa.lab2.data.sort_filter.SortFilter;
import com.soa.lab2.data.sort_filter.SortFilterRule;
import com.soa.lab2.exception.NoEntityException;
import com.soa.lab2.model.Difficulty;
import com.soa.lab2.model.Lab;
import com.soa.lab2.repository.DisciplineRepository;
import com.soa.lab2.repository.LabsRepository;
import com.soa.lab2.service.LabsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.ArrayList;
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
    public List<Lab> findAll(int page, int size, String sort) {
        System.out.println("!!!");
        if (sort != null) {
            ObjectMapper objectMapper = new ObjectMapper();

            try {
                SortFilter sortFilter = objectMapper.readValue(sort, SortFilter.class);
                Field[] allProperties = SortFilter.class.getDeclaredFields();
                List<Order> orders = new ArrayList<Order>();
                for (Field field : allProperties) {
                    String property = field.getName();
                    String value = ((SortFilterRule) field.get(sortFilter)).getSort();
                    if (value != null) {
                        Sort.Direction direction =
                                value.equals(OrderRule.ASCENDING.toString())
                                        ? OrderRule.ASCENDING.getDirection()
                                        : value.equals(OrderRule.DESCENDING.toString())
                                        ? OrderRule.DESCENDING.getDirection()
                                        : null;
//                    orders.add(
                        if (direction != null) orders.add(new Order(direction, property));
                    }
                }
//                System.out.println(sortFilter);
//                System.out.println(Arrays.toString(allProperties));
            } catch (JsonProcessingException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this.labsRepository.findAll(PageRequest.of(page, size, Sort.by("name").ascending())).getContent();
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
