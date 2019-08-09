package com.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:23
 */
@MapperScan(value = {"com.demo.dao","com.autocode.web.dao"})
@SpringBootApplication(scanBasePackages={"com.demo.*","com.autocode.*","com.common.*"})
public class Start {

    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }

}
