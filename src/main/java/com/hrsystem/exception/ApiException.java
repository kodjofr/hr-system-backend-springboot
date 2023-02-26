package com.hrsystem.exception;

public class ApiException extends RuntimeException{
    private final ApiExceptionType exceptionType;
    private final String message;

    public ApiException(ApiExceptionType type, String message){
        this.exceptionType = type;
        this.message = message;
    }
}
