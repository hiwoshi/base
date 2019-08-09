package com.common.process;

import com.common.base.BasePO;
import com.common.util.DateUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:33
 */
public class SqlHelper {

    @SuppressWarnings("unchecked")
    public static <T extends BasePO> String getInsertSql(T entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        initEntity(entity);
        Class c = entity.getClass();
        String tableName = getTableName(entity);
        Field[] fields = c.getDeclaredFields();
        Field[] fields1 = c.getSuperclass().getDeclaredFields();
        StringBuilder columns = new StringBuilder();
        StringBuilder values = new StringBuilder();
        columns.append("insert into ")
                .append(tableName)
                .append("(");
        values.append("values(");
        for (int i = 0 ; i<fields1.length;i++){
            Field field = fields1[i];
            DemoColumn annotation = field.getAnnotation(DemoColumn.class);
            if(null != annotation && annotation.doInsert()){
                columns.append(annotation.value()).append(",");
                String getMethodName = getMethodName(field.getName());
                values.append("'").append(c.getSuperclass().getDeclaredMethod(getMethodName).invoke(entity)).append("',");
            }
        }
        for (int i = 0 ; i<fields.length;i++){
            Field field = fields[i];
            DemoColumn annotation = field.getAnnotation(DemoColumn.class);
            if(null != annotation && annotation.doInsert()){
                columns.append(annotation.value()).append(",");
                String getMethodName = getMethodName(field.getName());
                values.append("'").append(c.getDeclaredMethod(getMethodName).invoke(entity)).append("',");
            }
        }
        columns.deleteCharAt(columns.length()-1);
        columns.append(")");
        values.deleteCharAt(values.length()-1);
        values.append(")");
        return columns.toString()+values.toString();
    }

    public static <T extends BasePO> String getDeleteSql(T entity) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String tableName = getTableName(entity);
        Object id = entity.getClass().getSuperclass().getDeclaredMethod("getId").invoke(entity);
        if(null == id){
            throw new NullPointerException("id can not be null!");
        }
        return String.format("delete from %s where id = %s",tableName,String.valueOf(id));
    }

    private static String getMethodName(String fieldName){
        StringBuilder stringBuilder = new StringBuilder("get")
                .append(fieldName.substring(0,1).toUpperCase());
        if(fieldName.length()>1){
            stringBuilder.append(fieldName.substring(1));
        }
        return stringBuilder.toString();
    }

    private static <T extends BasePO> String getTableName(T entity){
        return entity.getClass().getAnnotation(DemoTable.class).value();
    }

    //初始化entity
    private static  <T extends BasePO> void initEntity(T entity){
        String now = DateUtil.getNow();
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
    }

}
