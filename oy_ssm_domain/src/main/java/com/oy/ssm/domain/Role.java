package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import java.util.Date;
import java.util.List;

//角色表
public class Role {

    //角色的ID
    private Long rid;

    //角色的名字
    private String role_name;

    //权限级别
    private String permission;

    //角色的描述
    private String description;

    //创建的时间
    private Date create_time;

    //创建的时间 字符串格式
    private String create_timeStr;

    //角色对应的用户
    private List<UserInfo> userInfoList;

    public Long getRid() {
        return rid;
    }

    public void setRid(Long rid) {
        this.rid = rid;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    public void setUserInfoList(List<UserInfo> userInfoList) {
        this.userInfoList = userInfoList;
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

    @Override
    public String toString() {
        return "Role{" +
                "rid=" + rid +
                ", roleName='" + role_name + '\'' +
                ", permission='" + permission + '\'' +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                ", create_timeStr='" + create_timeStr + '\'' +
                ", userInfoList=" + userInfoList +
                '}';
    }
}
