package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import java.util.Date;
import java.util.List;

//部门表
public class Department {

    //部门的ID
    private Long did;

    //部门名称
    private String department_name;

    //部门描述
    private String description;

    //创建的时间
    private Date create_time;

    //创建的时间
    private String create_timeStr;

    //部门的用户，部门与用户是多对多关系
    private List<UserInfo> userInfoList;

    //部门下的职位，部门与职位是多对多关系
    private List<Position> positionList;

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
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

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "did=" + did +
                ", department_name='" + department_name + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", create_timeStr=" + create_timeStr +
                ", userInfoList=" + userInfoList +
                ", positionList=" + positionList +
                '}';
    }
}
