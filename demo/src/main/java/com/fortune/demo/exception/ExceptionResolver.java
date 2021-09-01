package com.fortune.demo.exception;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(NullPointerException.class)
    public String NullException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public String EmptyException(Exception e){
        return e.getMessage();
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return e.getMessage();
    }

}
