package com.common.base;

import com.common.process.DemoColumn;
import com.common.util.DateUtil;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:11
 */
public class BasePO<T> {

    @DemoColumn(value = "id",doInsert = false)
    private Long id;

    @DemoColumn("date")
    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateTime() {
        if(null == createTime) {
            createTime = DateUtil.getNow();
        }
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
