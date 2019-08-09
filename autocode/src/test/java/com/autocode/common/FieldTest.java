package com.autocode.common;

import org.junit.Test;

/**
 * @author : shenhao
 * @date : 2019/8/9 14:06
 */
public class FieldTest {

    @Test
    public void ConstructorTets(){
        Field field = new Field();
        field.setColumnName("userName");
        System.out.println(field.toString());
    }

}