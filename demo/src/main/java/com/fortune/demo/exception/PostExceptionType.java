package com.fortune.demo.exception;

import com.fortune.demo.domain.exceptionType.BaseExceptionType;

public enum PostExceptionType implements BaseExceptionType {

    NOT_FOUND_POST(1001, 200, "해당하는 포스트가 존재하지 않습니다.");

    private int errorCode;
    private int httpStatus;
    private String errorMessage;

    PostExceptionType(int errorCode, int httpStatus, String errorMessage) {
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errorMessage = errorMessage;
    }

    @Override
    public int getErrorCode() { return errorCode; }

    @Override
    public int getHttpStatus() { return httpStatus; }

    @Override
    public String getErrorMessage() { return errorMessage; }
}

