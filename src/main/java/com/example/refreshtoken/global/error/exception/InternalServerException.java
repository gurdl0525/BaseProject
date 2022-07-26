package com.example.refreshtoken.global.error.exception;

import com.example.refreshtoken.global.error.ErrorCode;

public class InternalServerException extends BaseException{
    private InternalServerException(){
        super(ErrorCode.INTERNAL_SERVER_ERROR);
    }

    private static class SingletonHelper{
        private static final InternalServerException INSTANCE = new InternalServerException();
    }
    public static InternalServerException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}