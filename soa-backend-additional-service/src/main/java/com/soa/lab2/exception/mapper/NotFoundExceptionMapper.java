package com.soa.lab2.exception.mapper;

import com.soa.lab2.data.ExceptionResponse;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
    @Override
    public Response toResponse(NotFoundException e) {
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionResponse(e.getClass().getName(), e.getMessage()))
                .build();
    }
}
