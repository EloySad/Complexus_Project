package com.riwi.complexus.api.error_handler;

import java.util.Collections;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.riwi.complexus.api.dto.errors.BaseErrorResponse;
import com.riwi.complexus.api.dto.errors.ErrorsResp;
import com.riwi.complexus.utils.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class ResourceNotFoundController {
    
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseErrorResponse handleResourceNotFound(ResourceNotFoundException exception) {
        return ErrorsResp.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .errors(Collections.singletonList(exception.getMessage()))
                .build();
    }
}
