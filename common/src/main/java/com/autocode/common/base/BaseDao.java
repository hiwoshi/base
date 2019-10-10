package com.autocode.common.base;

import com.autocode.common.process.DaoMethod;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.List;

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

    @UpdateProvider(
            type = DaoMethod.class,
            method = "delete"
    )
    int delete(P var1);

    @SelectProvider(
            type = DaoMethod.class,
            method = "findAll"
    )
    List<P> findAll(Class<P> var1);

    @SelectProvider(
            type = DaoMethod.class,
            method = "findByPage"
    )
    List<P> findByPage(P var1, Page page);

    @SelectProvider(
            type = DaoMethod.class,
            method = "countByExample"
    )
    int countByExample(P var1);

}
