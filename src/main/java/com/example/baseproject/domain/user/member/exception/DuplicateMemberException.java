package com.example.baseproject.domain.user.member.exception;

import com.example.baseproject.global.error.exception.ErrorCode;
import com.example.baseproject.global.error.exception.BaseException;

public class DuplicateMemberException extends BaseException {
    private DuplicateMemberException(){
        super(ErrorCode.DUPLICATE_MEMBER);
    }

    private static class SingletonHelper{
        private static final DuplicateMemberException INSTANCE = new DuplicateMemberException();
    }
    public static DuplicateMemberException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
