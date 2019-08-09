package com.autocode.web.dao;

import com.autocode.common.Table;
import org.apache.ibatis.annotations.InsertProvider;
import org.springframework.stereotype.Repository;


/**
 * @author : shenhao
 * @date : 2019/8/9 14:38
 */
@Repository
public interface AutocodeTableDao {

    @InsertProvider(
            type = DaoSql.class,
            method = "addTable"
    )
    int insert(Table table);

}
