package com.autocode.common.base;


import com.autocode.common.process.DemoColumn;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : shenhao
 * @date : 2019/7/31 13:11
 */
@Data
public class BasePO {

    @DemoColumn(value = "id")
    private String id;

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

    @DemoColumn("del_flag")
    private String delFlag = "0";

    private List<String> sqlWhere;

    private List<String> orderBy ;

    public void sqlWhereAnd(String sql){
        if (StringUtils.isEmpty(sql)) return;
        if (null == sqlWhere){
            sqlWhere = new ArrayList<>();
        }
        sqlWhere.add(sql);
    }

    public void orderByAnd(String order){
        if (StringUtils.isEmpty(order)) return;
        if (null == orderBy){
            orderBy = new ArrayList<>();
        }
        orderBy.add(order);
    }

}
