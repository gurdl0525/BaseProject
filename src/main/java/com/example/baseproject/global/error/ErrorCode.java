package com.example.baseproject.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    DUPLICATE_MEMBER(400, "Duplicate Member."),
    UN_AUTHORIZED_TOKEN_EXCEPTION(401, "Un Authorized Token."),
    INVALID_TOKEN(401, "Invalid Token."),
    PASSWORD_INCONSISTENCY(401, "Password Not Matched."),
    NOT_FOUND_USER(404, "Not Found User"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error.");

    private final Integer status;
    private final String message;
}
