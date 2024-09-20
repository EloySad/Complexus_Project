package com.riwi.complexus.api.exceptions;

import com.riwi.complexus.api.dto.exceptions.ExceptionBasic;
import com.riwi.complexus.api.dto.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFound {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ExceptionBasic userNotFoundException(UsernameNotFoundException exception){

        return ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }
}