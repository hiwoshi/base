package com.autocode.code.common;

/**
 * @author : shenhao
 * @date : 2019/8/7 14:32
 */
public class Field {

    /** userName */
    private String columnName;
    /** user_name */
    private String columnTableName;
    /** UserName */
    private String columnNameUp;
    /** Long */
    private String columnType;

    /** bigint */
    private String sqlColumnName;
    /** 11 */
    private Integer length;
    /** 默认为false */
    private boolean notNull = false;
    /** 字段注释，啦啦啦啦 */
    private String remark = "";

    public Field() {
    }

    public Field(String columnName, String columnType,String sqlColumnName, int length, boolean notNull, String remark) {
        this.setColumnName(columnName);
        this.columnType = columnType;
        this.sqlColumnName = sqlColumnName;
        this.length = length;
        this.notNull = notNull;
        this.remark = remark;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        columnTableName = StringUtils.changeToSqlStyle(columnName);
        columnNameUp = StringUtils.firstCharUpper(columnName);
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnTableName() {
        return columnTableName;
    }

    public String getColumnNameUp() {
        return columnNameUp;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public void setNotNull(boolean notNull) {
        this.notNull = notNull;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSqlColumnName() {
        return sqlColumnName;
    }

    public void setSqlColumnName(String sqlColumnName) {
        this.sqlColumnName = sqlColumnName;
    }
}
