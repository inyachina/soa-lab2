package com.soa.lab2.data.sort_filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.domain.Sort.Direction;

@Getter
@AllArgsConstructor
public enum OrderRule {
    ASCENDING(Direction.ASC),
    DESCENDING(Direction.DESC);

    private Direction direction;
}
