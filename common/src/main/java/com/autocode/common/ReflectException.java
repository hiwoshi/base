package com.autocode.common;

/**
 * @author : shenhao
 * @date : 2019/10/9 20:11
 */
public class ReflectException extends RuntimeException {

    public ReflectException(){}

    public ReflectException(String message) {
        super(message);
    }

    public ReflectException(String message, Exception e) {
        super(message,e);
    }

}
