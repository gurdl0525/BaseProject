package com.example.refreshtoken.global.error.exception;

import com.example.refreshtoken.global.error.ErrorCode;

public class PasswordInconsistencyException extends BaseException{

    private PasswordInconsistencyException() {
        super(ErrorCode.PASSWORD_INCONSISTENCY);
    }
    private static class SingletonHelper{
        private static final PasswordInconsistencyException INSTANCE = new PasswordInconsistencyException();
    }
    public static PasswordInconsistencyException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
