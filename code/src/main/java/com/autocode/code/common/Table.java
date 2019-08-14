package com.autocode.code.common;

import com.autocode.common.base.BasePO;

import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/8/9 13:48
 */
public class Table extends BasePO {

    private String tableName;   //SysUser
    private List<Field> fields; //userName

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }
}
