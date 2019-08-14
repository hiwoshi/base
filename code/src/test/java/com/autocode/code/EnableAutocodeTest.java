package com.autocode.code;

import com.autocode.code.common.Field;
import freemarker.template.TemplateException;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : shenhao
 * @date : 2019/8/7 11:12
 */
public class EnableAutocodeTest {

    @Test
    public void testEnableAutocode() throws IOException, TemplateException {
        Map<String,Object> map = new HashMap<>();
        map.put("className","Test");
        List<Field> list = new ArrayList<>();

        Field field1 = new Field();
        field1.setColumnName("userName");
        field1.setColumnType("String");
        Field field2 = new Field();
        field2.setColumnName("userAge");
        field2.setColumnType("Integer");
        list.add(field1);
        list.add(field2);
        map.put("columns",list);

        EnableAutocode.enableAutocode(map);
        System.out.println("ok");
    }

}
