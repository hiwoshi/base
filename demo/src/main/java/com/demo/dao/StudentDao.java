package com.demo.dao;

import com.common.base.BaseDao;
import com.demo.entity.Students;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:36
 */
@Repository
public interface StudentDao extends BaseDao<Students> {

    List<Students> getStudents();

}
