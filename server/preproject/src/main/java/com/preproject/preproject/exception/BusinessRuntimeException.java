package com.preproject.preproject.exception;

import lombok.Getter;

@Getter
public class BusinessRuntimeException extends RuntimeException{

    private final int code;
    private final CustomExceptionCode customExceptionCode;

    public BusinessRuntimeException(CustomExceptionCode customExceptionCode) {
        super(customExceptionCode.getDescription());
        this.code = customExceptionCode.getCode();
        this.customExceptionCode = customExceptionCode;
    }
}
