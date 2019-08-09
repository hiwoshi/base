package com.demo.autocode.web;

import com.autocode.common.Field;
import com.autocode.common.Table;
import com.autocode.web.service.AutocodeTableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/8/9 16:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutocodeTableServiceTest {

    @Autowired
    private AutocodeTableService autocodeTableService;

    @Test
    public void addTableTest(){
        Table table = new Table();
        table.setTableName("SysUser");
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("userName","String","varchar",10,false,"用户名"));
        fields.add(new Field("userAge","int","int",0,false,"用户年龄"));
        table.setFields(fields);
        autocodeTableService.addTable(table);
        System.out.println("-------ok---------");
    }

}
