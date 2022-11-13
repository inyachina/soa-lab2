package com.soa.lab2.dao.sort_filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterDTO {
    private FilterRuleDTO name;

    private FilterRuleDTO x;

    private FilterRuleDTO y;

    private FilterRuleDTO creationDate;

    private FilterRuleDTO minimalPoint;

    private FilterRuleDTO personalQualitiesMaximum;

    private FilterRuleDTO difficulty;

    private FilterRuleDTO disciplineName;
}
