package com.example.refreshtoken.global.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    DUPLICATE_MEMBER(400, "DUPLICATE MEMBER : 중복된 회원입니다."),
    UN_AUTHORIZED_TOKEN_EXCEPTION(401, "UN_AUTHORIZED_TOKEN_EXCEPTION : 인증되지 않은 토큰입니다."),
    INVALID_TOKEN(401, "Invalid Token."),
    PASSWORD_NOT_MATCHED(401, "PASSWORD_NOT_MATCHED : 비밀번호가 틀렸습니다."),
    FORBIDDEN(403, "FORBIDDEN : 권한 오류"),
    NOT_FOUND_USER(404, "NOT_FOUND_USER : 사용자를 찾을 수 없습니다."),
    INTERNAL_SERVER_ERROR(500, "INTERNAL_SERVER_ERROR : 서버 내부 에러입니다.");

    private final Integer status;
    private final String message;
}
