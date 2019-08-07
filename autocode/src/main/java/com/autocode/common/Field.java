package com.autocode.common;

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

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        setColumnNameUp();
        setColumnTableName();
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

    /**
     * 将驼峰转化为_表达式，默认对应数据库的列字段名
     */
    public void setColumnTableName(){
        String str = columnName;
        for (int i = 1; i < columnName.length(); i++) {
            if(Character.isUpperCase(columnName.charAt(i))){
                String s = columnName.charAt(i)+"";
                str = str.replace(s,"_"+s);
            }
        }
        columnTableName = str.toLowerCase();
    }

    /**
     * 将驼峰转化为_表达式，默认对应数据库的列字段名
     */
    public void setColumnNameUp(){
        String str = columnName;
        columnNameUp = str.substring(0,1).toUpperCase()+str.substring(1);
    }


}
