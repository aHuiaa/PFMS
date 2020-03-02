package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;

import java.util.Date;
import java.util.List;

public class Position {

    //职位ID
    private Long pid;
    //职位名称
    private String position_name;
    //职位描述
    private String description;
    //创建时间
    private Date create_time;
    private String create_timeStr;
    //职位-部门，多对多关系
    private List<Department> departmentList;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_timeStr() {
        return DateUtils.date2String(create_time,"yyyy-MM-dd HH:mm:ss");
    }

    public void setCreate_timeStr(String create_timeStr) {
        this.create_timeStr = create_timeStr;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pid=" + pid +
                ", position_name='" + position_name + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", create_timeStr='" + create_timeStr + '\'' +
                ", departmentList=" + departmentList +
                '}';
    }
}
