package com.autocode.common.base;

import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/7/31 16:22
 */
public interface BaseService<P extends BasePO> {

    int insert(P var1);

    int delete(P var1);

    List<P> findAll();

    Page<P> findByPage(P var1, Page<P> page);

    List<P> findByExample(P var1);


}
