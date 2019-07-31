package com.common.base;

import com.common.process.DaoMethod;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:34
 */
public interface BaseDao<P extends BasePO> {

    @InsertProvider(
            type = DaoMethod.class,
            method = "insert"
    )
    int insert(P var1);

    @DeleteProvider(
            type = DaoMethod.class,
            method = "delete"
    )
    int delete(P var1);

}
