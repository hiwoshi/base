package com.autocode.common.base;

import lombok.Data;

import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/10/8 16:53
 */
@Data
public class Page<T extends BasePO> {

    private int pageSize = 10;
    private int currentNum = 1;

    private int pageTotal;
    private int totalCount;

    private List<T> data;

}
