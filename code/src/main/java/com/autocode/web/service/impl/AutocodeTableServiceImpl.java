package com.autocode.web.service.impl;

import com.autocode.code.EnableAutocode;
import com.autocode.code.common.SqlException;
import com.autocode.code.common.Table;
import com.autocode.web.dao.AutocodeTableDao;
import com.autocode.web.service.AutocodeTableService;
import com.autocode.common.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shenhao
 * @date : 2019/8/14 13:55
 */
@Service
public class AutocodeTableServiceImpl extends BaseServiceImpl<AutocodeTableDao, Table> implements AutocodeTableService {

    @Override
    public String addTable(Table table){
        dao.tableInsert(table);
        Map<String,Object> map = new HashMap<>();
        map.put("className",table.getTableName());
        map.put("fields",table.getFields());
        try {
            EnableAutocode.enableAutocode(map);
        } catch (Exception e) {
            throw new SqlException(e.getMessage());
        }
        return "ok";
    }

}
