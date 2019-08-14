package com.autocode.web.dao;

import com.autocode.code.common.Table;
import com.autocode.common.base.BaseDao;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;


/**
 * @author : shenhao
 * @date : 2019/8/9 14:38
 */
@Mapper
public interface AutocodeTableDao extends BaseDao<Table> {

    @InsertProvider(
            type = DaoSql.class,
            method = "addTable"
    )
    int tableInsert(Table table);

}
