package com.example.baseproject.domain.user.auth.exception;

import com.example.baseproject.global.error.ErrorCode;
import com.example.baseproject.global.error.exception.BaseException;

public class UnAuthorizedTokenException extends BaseException {

    private UnAuthorizedTokenException(){
        super(ErrorCode.UN_AUTHORIZED_TOKEN_EXCEPTION);
    }

    private static class SingletonHelper{
        private static final UnAuthorizedTokenException INSTANCE = new UnAuthorizedTokenException();
    }

    public static UnAuthorizedTokenException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
