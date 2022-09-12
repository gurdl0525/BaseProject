package com.example.baseproject.global.error.exception;

public class NotFoundException extends BaseException {
    private NotFoundException(){
        super(ErrorCode.NOT_FOUND);
    }
    private static class SingletonHelper{
        private static final NotFoundException INSTANCE = new NotFoundException();
    }
    public static NotFoundException getInstance(){
        return SingletonHelper.INSTANCE;
    }
}
