package com.common.process;

import com.common.base.BasePO;
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
            e.printStackTrace();
        }
        logger.info("sql....[{}]",str);
        return str;
    }

    public <T extends BasePO> String delete(T entity){
        String str = null;
        try {
            str = SqlHelper.getDeleteSql(entity);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        logger.info("sql....[{}]",str);
        return str;
    }



}
