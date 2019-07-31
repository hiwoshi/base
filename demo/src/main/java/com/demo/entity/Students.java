package com.demo.entity;

import com.common.base.BasePO;
import com.common.process.DemoColumn;
import com.common.process.DemoTable;

/**
 * @author : shenhao
 * @date : 2019/7/31 10:36
 */
@DemoTable("students")
public class Students extends BasePO {

    @DemoColumn("name")
    private String name;
    @DemoColumn("age")
    private int age;
    private String classId;
    private String state;
    private String processId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }
}
