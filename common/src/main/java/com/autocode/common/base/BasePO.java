package com.autocode.common.base;

import com.autocode.common.process.DemoColumn;
import com.autocode.common.util.DateUtil;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:11
 */
public class BasePO<T> {

    @DemoColumn(value = "id",doInsert = false)
    private Long id;

    @DemoColumn("create_time")
    private String createTime;

    @DemoColumn("create_by")
    private String createBy;

    @DemoColumn("update_time")
    private String updateTime;

    @DemoColumn("update_by")
    private String updateBy;

    @DemoColumn("remarks")
    private String remarks;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //这里的赋值应该放在add方法里，后续需要改掉
    public String getCreateTime() {
        if(null == createTime) {
            createTime = DateUtil.getNow();
        }
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
