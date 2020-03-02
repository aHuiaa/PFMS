package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;

import java.util.Date;

public class Notice {

    //公告ID
    Long nid;
    //公告标题
    String title;
    //公告内容
    String content;
    //发布时间
    Date create_time;
    String create_timeStr;
    //公告-用户 多对一
    UserInfo userInfo;

    public Long getNid() {
        return nid;
    }

    public void setNid(Long nid) {
        this.nid = nid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_timeStr() {

        if (create_time != null){
        return DateUtils.date2String(create_time,"yyyy年MM月dd日 HH:mm");
        }else
            return null;
    }

    public void setCreate_timeStr(String create_timeStr) {
        this.create_timeStr = create_timeStr;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "nid=" + nid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", create_time=" + create_time +
                ", create_timeStr='" + create_timeStr + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }
}
