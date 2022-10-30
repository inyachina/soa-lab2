package com.soa.lab2.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FilterDTO {
    private String field;
    private String regex;
}
