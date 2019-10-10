package com.autocode.common.process;

import com.background.common.ReflectException;
import com.background.common.base.BasePO;
import com.background.common.base.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:15
 */
public class DaoMethod {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public <T extends BasePO> String insert(T entity){
        String str = null;
        try {
            str = SqlHelper.getInsertSql(entity);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ReflectException("parse sql error ,",e);
        }
        logger.info("sql.insert...[{}]",str);
        return str;
    }

    public <T extends BasePO> String delete(T entity){
        String str = null;
        try {
            str = SqlHelper.getDeleteSql(entity);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new ReflectException("parse sql error ,",e);
        }
        logger.info("sql.delete...[{}]",str);
        return str;
    }

    public <T extends BasePO> String findAll(Class<T> entity){
        String str = SqlHelper.findAll(entity);
        logger.info("sql.findAll...[{}]",str);
        return str;
    }

    public <T extends BasePO> String findByPage(T entity, Page page){
        String str = null;
        str = SqlHelper.findByPage(entity,page);
        logger.info("sql.findByPage...[{}]",str);
        return str;
    }

    public <T extends BasePO> String countByExample(T entity){
        String str = null;
        str = SqlHelper.countByExample(entity);
        logger.info("sql.countByExample...[{}]",str);
        return str;
    }



}
