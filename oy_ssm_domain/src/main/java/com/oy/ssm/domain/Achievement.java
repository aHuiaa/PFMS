package com.oy.ssm.domain;


//荣誉实体类
public class Achievement {

    //荣誉ID
    private Long ach_id;
    //荣誉名称
    private String ach_name;
    //荣誉介绍
    private String description;
    //获奖用户
    private UserInfo userInfo;

    public Long getAch_id() {
        return ach_id;
    }

    public void setAch_id(Long ach_id) {
        this.ach_id = ach_id;
    }

    public String getAch_name() {
        return ach_name;
    }

    public void setAch_name(String ach_name) {
        this.ach_name = ach_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "ach_id=" + ach_id +
                ", ach_name=" + ach_name +
                ", description='" + description + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
