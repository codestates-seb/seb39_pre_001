package com.preproject.preproject.advice;

import com.preproject.preproject.exception.BusinessLogicException;
import com.preproject.preproject.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionAdvice {

    @ExceptionHandler
    public ResponseEntity notFoundException(BusinessLogicException e) {
        System.out.println(e.getExceptionCode().getStatus());
        System.out.println(e.getMessage());
        final ErrorResponse response = ErrorResponse.of(e.getExceptionCode());

        return new ResponseEntity<>(response, HttpStatus.valueOf(e.getExceptionCode().getStatus()));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ) {
        return exception.getBindingResult();
    }
}
