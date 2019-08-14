package com.autocode.code.common;

/**
 * @author : shenhao
 * @date : 2019/8/9 14:50
 */
public class SqlException extends RuntimeException {

    public SqlException() {
    }

    public SqlException(String message) {
        super(message);
    }
}
