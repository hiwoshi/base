package com.autocode.demo.springboot;

import com.alibaba.fastjson.JSON;
import com.autocode.web.dao.StudentDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : shenhao
 * @date : 2019/8/7 16:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentDaoTest {

    @Autowired
    private StudentDao studentDao;

    @Test
    public void test(){
        String s = JSON.toJSONString(studentDao.getStudents());
        System.out.println(s);
    }


}
