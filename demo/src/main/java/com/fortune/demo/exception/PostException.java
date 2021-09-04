package com.fortune.demo.exception;

import com.fortune.demo.domain.exceptionType.BaseExceptionType;

public class PostException extends RuntimeException {
    private BaseExceptionType exceptionType;

    public PostException(BaseExceptionType eT){
        super(eT.getErrorMessage());
        this.exceptionType = eT;
    }

    public BaseExceptionType getExceptionType() {
        return exceptionType;
    }
}


