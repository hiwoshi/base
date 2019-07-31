package com.common.base;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:22
 */
public interface BaseService<P extends BasePO> {

    int insert(P var1);

    int delete(P var1);


}
