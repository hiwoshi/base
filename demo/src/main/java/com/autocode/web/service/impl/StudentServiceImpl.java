package com.autocode.web.service.impl;

import com.alibaba.fastjson.JSON;
import com.autocode.common.base.BaseServiceImpl;
import com.autocode.web.dao.StudentDao;
import com.autocode.web.entity.Students;
import com.autocode.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:35
 */
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentDao, Students> implements StudentService {
    @Autowired
    private StudentDao testDao;

    @Override
    public String test() {
        return JSON.toJSONString(testDao.getStudents());
    }

}
