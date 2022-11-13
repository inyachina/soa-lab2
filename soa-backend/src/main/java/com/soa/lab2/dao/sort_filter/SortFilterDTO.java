package com.soa.lab2.dao.sort_filter;

import lombok.Data;
import lombok.NonNull;

@Data
public class SortFilterDTO {

    @NonNull
    private Integer size;
    @NonNull
    private Integer page;

    private SortDTO sort;
}
