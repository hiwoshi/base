package com.autocode.common.process;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:30
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface DemoColumn {

    String value();

    boolean doInsert() default true;

    SqlFactor factor() default SqlFactor.EQUALS;

}
