package com.autocode.web.controller;

import com.autocode.code.common.Table;
import com.autocode.web.service.AutocodeTableService;
import com.autocode.common.base.BaseController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author : shenhao
 * @date : 2019/8/9 13:21
 */
@RequestMapping("/autocodeTable")
@RestController
public class AutocodeTableController extends BaseController<AutocodeTableService,Table> {

    @RequestMapping("/add")
    public String add(@Valid @RequestBody Table table){
        return service.addTable(table);
    }


}
