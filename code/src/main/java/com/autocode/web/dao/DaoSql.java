package com.autocode.web.dao;

import com.autocode.code.common.Field;
import com.autocode.code.common.StringUtils;
import com.autocode.code.common.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author : shenhao
 * @date : 2019/8/9 14:37
 */
public class DaoSql {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public String addTable(Table table){
        StringBuilder stringBuilder = new StringBuilder("create table " + StringUtils.changeToSqlStyle(table.getTableName()) + "(\n");
        stringBuilder.append(" id bigint(20) not null comment 'ID',\n");
        stringBuilder.append(" create_time datetime comment '创建时间',\n");
        stringBuilder.append(" create_by bigint(20)  comment '创建者',\n");
        stringBuilder.append(" update_time datetime  comment '更新时间',\n");
        stringBuilder.append(" update_by bigint(20)  comment '更新者',\n");
        stringBuilder.append(" remarks varchar(100)  comment '备注',\n");
        for(Field field : table.getFields()){
            stringBuilder.append(StringUtils.changeToSqlStyle(field.getColumnName()))
                    .append(" ")
                    .append(field.getSqlColumnName());
            if ("varchar".equals(field.getSqlColumnName()) || "char".equals(field.getSqlColumnName()) || "bigint".equals(field.getSqlColumnName())){
                stringBuilder.append("(").append(field.getLength()).append(") ");
            }else {
                stringBuilder.append(" ");
            }
            if(field.isNotNull()){
                stringBuilder.append("not null ");
            }
            if(null != field.getRemark()){
                stringBuilder.append("comment \'").append(field.getRemark()).append("\'");
            }
            stringBuilder.append(" ,\n");
        }
        stringBuilder.delete(stringBuilder.length()-2,stringBuilder.length());
        stringBuilder.append(")");

        logger.info("sql....{}",stringBuilder.toString());
        return stringBuilder.toString();
    }


}
