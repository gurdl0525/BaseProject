package com.example.baseproject.global.error.exception;

import com.example.baseproject.global.error.ErrorCode;

public class InvalidTokenException extends BaseException{
    private InvalidTokenException(){
        super(ErrorCode.INVALID_TOKEN);
    }
    private static class SingletonHelper{
        private static final InvalidTokenException INSTANCE = new InvalidTokenException();
    }
    public static InvalidTokenException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
