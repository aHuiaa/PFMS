package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//合同的实体类
public class Contract {

    //合同id
    private Long cid;

    //用户的id
    private Long uid;

    //合同开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_time;
    private String start_timeStr;

    //合同到期时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_time;
    private String end_timeStr;

    //合同文件
    private String contract;

    //合同对应的用户 用户-合同-一度多，用户可以有多份合同
    private UserInfo userInfo;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getStart_timeStr() {
        if (start_time!=null){
            return DateUtils.date2String(start_time,"yyyy-MM-dd");
        }
        return null;
    }

    public void setStart_timeStr(String start_timeStr) {
        this.start_timeStr = start_timeStr;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public String getEnd_timeStr() {
        if (start_time!=null){
            return DateUtils.date2String(end_time,"yyyy-MM-dd");
        }
        return null;
    }

    public void setEnd_timeStr(String end_timeStr) {
        this.end_timeStr = end_timeStr;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", start_time=" + start_time +
                ", start_timeStr='" + start_timeStr + '\'' +
                ", end_time=" + end_time +
                ", end_timeStr='" + end_timeStr + '\'' +
                ", contract='" + contract + '\'' +
                ", userInfo=" + userInfo +
                '}';
    }

}
