package com.autocode.common.process;

/**
 * @author : shenhao
 * @date : 2019/10/9 15:53
 */
public enum SqlFactor {
    EQUALS(0,"%s=%s"),
    LIKE(1,"%s like '%%%s%%'"),
    LEFT_LIKE(2, "%s like '%s%%'"),
    RIGHT_LIKE(3, "%s like '%%%s'");

    private int code;
    private String express;

    SqlFactor(int code, String express){
        this.code = code;
        this.express = express;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getExpress() {
        return express;
    }

    public void setExpress(String express) {
        this.express = express;
    }
}
