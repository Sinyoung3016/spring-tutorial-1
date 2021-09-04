package com.fortune.demo.exception;

import com.fortune.demo.domain.exceptionType.BaseExceptionType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(PostException.class)
    public ResponseEntity<Error> handlePostException(PostException e){
        return new ResponseEntity<>(Error.create(e.getExceptionType()), HttpStatus.OK);
    }

    static class Error{
        private int code;
        private int status;
        private String message;

        public Error(int code, int status, String message){
            this.code = code;
            this.status = status;
            this.message = message;
        }

        static Error create(BaseExceptionType exceptionType){
            return new Error(exceptionType.getErrorCode(), exceptionType.getHttpStatus(), exceptionType.getErrorMessage());
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        public int getCode() {
            return code;
        }
    }
}


