package com.soa.lab2.dao;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;

@NonNull
@Data
public class ApiResponse {
    private int code;
    private String type;
    private String message;
}
