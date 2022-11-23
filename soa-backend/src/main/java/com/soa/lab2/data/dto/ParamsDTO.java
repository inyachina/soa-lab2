package com.soa.lab2.data.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@NonNull
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ParamsDTO {
    private int size;
    private int page;
    private String sortField;
    private boolean ascending;
}
