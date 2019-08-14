package com.autocode.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:23
 */
@SpringBootApplication(scanBasePackages={"com.autocode.*"})
public class Start {

    public static void main(String[] args) {
        SpringApplication.run(Start.class,args);
    }

}
