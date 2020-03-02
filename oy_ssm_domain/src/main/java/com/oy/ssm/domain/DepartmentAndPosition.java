package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;

import java.util.Date;

public class DepartmentAndPosition {
    private Long dpid;

    private Long did;

    private Long pid;

    private Date create_time;

    private String create_timeStr;

    private Department department;

    private Position position;

    public Long getDpid() {
        return dpid;
    }

    public void setDpid(Long dpid) {
        this.dpid = dpid;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }


    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "DepartmentAndPosition{" +
                "dpid=" + dpid +
                ", did=" + did +
                ", pid=" + pid +
                ", create_time=" + create_time +
                ", create_timeStr='" + create_timeStr + '\'' +
                ", department=" + department +
                ", position=" + position +
                '}';
    }
}
