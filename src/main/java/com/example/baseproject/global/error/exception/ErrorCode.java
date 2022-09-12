package com.example.baseproject.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    DUPLICATE_MEMBER(HttpStatus.BAD_REQUEST, "Duplicate Member."),
    UN_AUTHORIZED_TOKEN(HttpStatus.UNAUTHORIZED, "Un Authorized Token."),
    PASSWORD_INCONSISTENCY(HttpStatus.UNAUTHORIZED, "Password Not Matched."),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Not Found"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error.");

    private final HttpStatus status;
    private final String message;
}
