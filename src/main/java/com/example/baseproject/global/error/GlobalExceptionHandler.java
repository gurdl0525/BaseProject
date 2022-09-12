package com.example.baseproject.global.error;

import com.example.baseproject.global.error.exception.BaseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<? extends String> baseException(BaseException e){
        return ResponseEntity.status(e.getErrorCode().getStatus())
                .body(e.getErrorCode().getMessage());
    }
}
