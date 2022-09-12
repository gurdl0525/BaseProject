package com.example.baseproject.domain.user.auth.exception;

import com.example.baseproject.global.error.ErrorCode;
import com.example.baseproject.global.error.exception.BaseException;

public class NotFoundUserException extends BaseException {
    private NotFoundUserException(){
        super(ErrorCode.NOT_FOUND_USER);
    }
    private static class SingletonHelper{
        private static final NotFoundUserException INSTANCE = new NotFoundUserException();
    }
    public static NotFoundUserException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
