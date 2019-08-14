package com.autocode.web.controller;

import com.autocode.web.base.DefaultController;
import com.autocode.web.entity.Students;
import com.autocode.web.service.StudentService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:23
 */
@RestController
@RequestMapping("/test1")
@Api(value = "/test1" , tags = "测试")
public class StudentController extends DefaultController<StudentService, Students> {

    @RequestMapping("/test")
    public String test(){
        return service.test();
    }


}
