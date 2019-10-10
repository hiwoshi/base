package com.autocode.common.base;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:31
 */
public class BaseController<S extends BaseService,P extends BasePO> {

    @Autowired
    protected S service;



}
