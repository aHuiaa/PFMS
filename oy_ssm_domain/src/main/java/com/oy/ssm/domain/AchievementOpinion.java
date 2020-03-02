package com.oy.ssm.domain;


import com.oy.ssm.utils.DateUtils;

import java.util.Date;

public class AchievementOpinion {

    //奖项审批单的ID
    private Long oid;
    //审批用户ID
    private Long uid;
    //奖项的ID
    private Long ach_id;
    //申请理由
    private String reason;
    //申请的时间
    private Date a_time;
    private String a_timeStr;
    //审批结果
    private String opinion;
    //审批意见
    private String opinion_content;
    //审批者
    private String approver;
    //审批的时间
    private Date o_time;
    private String o_timeStr;
    //申请的用户
    private UserInfo userInfo;
    //申请的奖项
    private Achievement achievement;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getAch_id() {
        return ach_id;
    }

    public void setAch_id(Long ach_id) {
        this.ach_id = ach_id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getA_time() {
        return a_time;
    }

    public void setA_time(Date a_time) {
        this.a_time = a_time;
    }

    public String getA_timeStr() {

        if (a_time!=null){
            return DateUtils.date2String(a_time,"yyyy-MM-dd");
        }
        return "";
    }

    public void setA_timeStr(String a_timeStr) {
        this.a_timeStr = a_timeStr;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public String getOpinion_content() {
        return opinion_content;
    }

    public void setOpinion_content(String opinion_content) {
        this.opinion_content = opinion_content;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public Date getO_time() {
        return o_time;
    }

    public void setO_time(Date o_time) {
        this.o_time = o_time;
    }

    public String getO_timeStr() {
        if (o_time!=null){
            return DateUtils.date2String(o_time,"yyyy-MM-dd");
        }
        return "";
    }

    public void setO_timeStr(String o_timeStr) {
        this.o_timeStr = o_timeStr;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement) {
        this.achievement = achievement;
    }

    @Override
    public String toString() {
        return "AchievementOpinion{" +
                "oid=" + oid +
                ", uid=" + uid +
                ", ach_id=" + ach_id +
                ", reason='" + reason + '\'' +
                ", a_time=" + a_time +
                ", a_timeStr='" + a_timeStr + '\'' +
                ", opinion='" + opinion + '\'' +
                ", opinion_content='" + opinion_content + '\'' +
                ", approver='" + approver + '\'' +
                ", o_time=" + o_time +
                ", o_timeStr='" + o_timeStr + '\'' +
                ", userInfo=" + userInfo +
                ", achievement=" + achievement +
                '}';
    }
}
