package com.example.baseproject.domain.user.auth.exception;

import com.example.baseproject.global.error.exception.ErrorCode;
import com.example.baseproject.global.error.exception.BaseException;

public class PasswordInconsistencyException extends BaseException {

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
