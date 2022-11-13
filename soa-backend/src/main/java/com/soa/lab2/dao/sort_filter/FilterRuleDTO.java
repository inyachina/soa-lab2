package com.soa.lab2.dao.sort_filter;

import lombok.Data;

@Data
public class FilterRuleDTO {
    private String field;
    private String regex;
}
