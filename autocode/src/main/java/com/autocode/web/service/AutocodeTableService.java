package com.autocode.web.service;

import com.autocode.EnableAutocode;
import com.autocode.common.SqlException;
import com.autocode.common.Table;
import com.autocode.web.dao.AutocodeTableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shenhao
 * @date : 2019/8/9 13:45
 */
@Service
public class AutocodeTableService {

    @Autowired
    private AutocodeTableDao autocodeTableDao;

    public String addTable(Table table){
        autocodeTableDao.insert(table);
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
