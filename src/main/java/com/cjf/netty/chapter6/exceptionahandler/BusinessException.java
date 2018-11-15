package com.cjf.netty.chapter6.exceptionahandler;

public class BusinessException extends Exception {

    public BusinessException(String message) {
        super(message);
    }
}
