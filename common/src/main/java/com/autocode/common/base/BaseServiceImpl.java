package com.autocode.common.base;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:22
 */
public class BaseServiceImpl<D extends BaseDao,P extends BasePO> implements BaseService<P> {

    @Autowired
    protected D dao;


    @Override
    public int insert(P var1) {
        return dao.insert(var1);
    }

    @Override
    public int delete(P var1) {
        return dao.delete(var1);
    }
}
