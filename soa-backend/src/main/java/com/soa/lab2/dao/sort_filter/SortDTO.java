package com.soa.lab2.dao.sort_filter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class SortDTO {

    @Nullable
    private SortOrderType name;

    @Nullable
    private SortOrderType x;

    @Nullable
    private SortOrderType y;

    @Nullable
    private SortOrderType creationDate;

    @Nullable
    private SortOrderType minimalPoint;

    @Nullable
    private SortOrderType personalQualitiesMaximum;

    @Nullable
    private SortOrderType difficulty;

    @Nullable
    private SortOrderType disciplineName;
}
