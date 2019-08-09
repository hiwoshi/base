package com.autocode.web.controller;

import com.autocode.common.Table;
import com.autocode.web.service.AutocodeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : shenhao
 * @date : 2019/8/9 13:21
 */
@RequestMapping("/table")
@RestController
public class AutocodeTableController {

    @Autowired
    private AutocodeTableService autocodeTableService;

    @RequestMapping("/add")
    public String add(@Valid @RequestBody Table table){
        return autocodeTableService.addTable(table);
    }


}
