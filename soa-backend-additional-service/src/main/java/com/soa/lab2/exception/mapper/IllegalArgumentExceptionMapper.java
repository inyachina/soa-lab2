package com.soa.lab2.exception.mapper;


import com.soa.lab2.data.ExceptionResponse;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class IllegalArgumentExceptionMapper implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException e) {
        return Response.status(422)
                .entity(new ExceptionResponse(e.getClass().getName(), "Validation failed"))
                .build();
    }
}
