package com.autocode.web.dao;

import com.autocode.common.base.BaseDao;
import com.autocode.web.entity.Students;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:36
 */
@Mapper
public interface StudentDao extends BaseDao<Students> {

    List<Students> getStudents();

}
