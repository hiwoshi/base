package com.autocode.common.process;

import com.background.common.base.BasePO;
import com.background.common.base.Page;
import com.background.common.util.DateUtil;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

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
        String id = entity.getId();
        if(null == id){
            throw new NullPointerException("id can not be null!");
        }
        return String.format("update %s set del_flag = 1 where id = %s",tableName,id);
    }

    public static <T extends BasePO> String findAll(Class<T> entity) {
        String tableName = getTableName(entity);
        return "select * from " + tableName + " where (del_flag = 0)";
    }

    public static <T extends BasePO> String findByPage(T entity, Page page){
        String tableName = getTableName(entity);
        StringBuilder sb = new StringBuilder("select * from ");
        sb.append(tableName).append(" where (del_flag = 0)");
        sb.append(getWhereSql(entity));
        List<String> orders = entity.getOrderBy();
        if(null != orders && orders.size()>0){
            sb.append(" order by ").append(String.join(",",orders));
        }
        if (null != page){
            sb.append(" limit ");
            if (1 == page.getCurrentNum()){
                sb.append(page.getPageSize());
            }else {
                sb.append((page.getCurrentNum()-1)*page.getPageSize()).append(",").append(page.getPageSize());
            }
        }
        return sb.toString();

    }

    public static <T extends BasePO> String countByExample(T entity) {
        String tableName = getTableName(entity);
        return "select count(0) from " + tableName + " where (del_flag = 0)" + getWhereSql(entity);
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

    private static <T extends BasePO> String getTableName(Class<T> entity){
        return entity.getAnnotation(DemoTable.class).value();
    }

    //初始化entity
    private static <T extends BasePO> void initEntity(T entity){
        String now = DateUtil.getNow();
        entity.setCreateTime(now);
        entity.setUpdateTime(now);
    }

    private static Field getFieldByName(String name,Class c){
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields){
            if (name.equals(field.getName())) return field;
        }
        Field[] fields1 = c.getSuperclass().getDeclaredFields();
        for (Field field : fields1){
            if (name.equals(field.getName())) return field;
        }
        return null;
    }

    private static <T extends BasePO> String getWhereSql(T entity){
        List<String> sqlWhere = entity.getSqlWhere();
        StringBuilder sb = new StringBuilder();
        if(null != sqlWhere && sqlWhere.size()>0){
            for (String str : sqlWhere){
                if (str.indexOf("=")>0 && !str.contains("<") && !str.contains(">")){
                    String fieldstr = str.substring(0,str.indexOf("="));
                    String otherStr = str.substring(str.indexOf("=")+1);
                    Field field;
                    if ((field = getFieldByName(fieldstr,entity.getClass())) != null){
                        DemoColumn annotation = field.getAnnotation(DemoColumn.class);
                        sb.append(" and ").append(String.format(annotation.factor().getExpress(),annotation.value(),otherStr));
                    }
                }else{
                    String fieldstr;
                    Field field;
                    if (str.indexOf(">")>0){
                        fieldstr = str.substring(0,str.indexOf(">"));
                    }else{
                        fieldstr = str.substring(0,str.indexOf("<"));
                    }
                    if ((field = getFieldByName(fieldstr,entity.getClass())) != null){
                        sb.append(" and ").append(str.replace(field.getName(),field.getAnnotation(DemoColumn.class).value()));
                    }
                }
            }
        }
        return sb.toString();
    }

}
