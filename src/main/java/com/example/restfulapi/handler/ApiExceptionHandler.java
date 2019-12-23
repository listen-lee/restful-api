package com.example.restfulapi.handler;/*
 * @program: restful-api
 *
 * @description:
 *
 * @author: guangpeng.li
 *
 * @create: 2019-12-23 15:56
 */

import com.example.restfulapi.exception.InvalidRequestException;
import com.example.restfulapi.exception.ResourceNotFoundException;
import com.example.restfulapi.resource.ErrorResource;
import com.example.restfulapi.resource.FieldResource;
import com.example.restfulapi.resource.InvalidErrorResource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public HttpEntity<?> handlerNotFound(ResourceNotFoundException e) {
        ErrorResource errorResource = new ErrorResource(e.getMessage());
        log.error(errorResource.toString());
        return new ResponseEntity<>(errorResource, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = InvalidRequestException.class)
    public HttpEntity<?> handlerInvalidRequest(InvalidRequestException e) {
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        fieldErrors.forEach(fieldError -> {
            fieldResources.add(new FieldResource(fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getCode(),
                    fieldError.getDefaultMessage()));
        });
        InvalidErrorResource invalidErrorResource = new InvalidErrorResource(e.getMessage(), fieldResources);
        log.error(invalidErrorResource.toString());
        return new ResponseEntity<>(invalidErrorResource, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public HttpEntity<?> handlerException(Exception e) {
        log.error(e.getMessage());
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
