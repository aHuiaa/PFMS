package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class Cultivate {

    //培训的ID
    private Long cul_id;
    //培训名称
    private String cul_name;
    //培训内容
    private String content;
    //培训地点
    private String address;
    //培训开始的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date start_time;
    private String start_timeStr;
    //培训结束的时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date end_time;
    private String end_timeStr;
    //培训的记录
    private List<UserCultivate> userCultivateList;

    public Long getCul_id() {
        return cul_id;
    }

    public void setCul_id(Long cul_id) {
        this.cul_id = cul_id;
    }

    public String getCul_name() {
        return cul_name;
    }

    public void setCul_name(String cul_name) {
        this.cul_name = cul_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "";
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
            return DateUtils.date2String(start_time,"yyyy-MM-dd");
        }
        return "";
    }

    public void setEnd_timeStr(String end_timeStr) {
        this.end_timeStr = end_timeStr;
    }

    public List<UserCultivate> getUserCultivateList() {
        return userCultivateList;
    }

    public void setUserCultivateList(List<UserCultivate> userCultivateList) {
        this.userCultivateList = userCultivateList;
    }

    @Override
    public String toString() {
        return "Cultivate{" +
                "cul_id=" + cul_id +
                ", cul_name='" + cul_name + '\'' +
                ", content='" + content + '\'' +
                ", address='" + address + '\'' +
                ", start_time=" + start_time +
                ", start_timeStr='" + start_timeStr + '\'' +
                ", end_time=" + end_time +
                ", end_timeStr='" + end_timeStr + '\'' +
                ", userCultivateList=" + userCultivateList +
                '}';
    }
}
