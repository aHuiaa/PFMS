package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;

import java.util.Date;


public class SysLog {

    private String lid;              //日志ID
    private Date visit_time;        //访问时间
    private String visit_timeStr;   //访问时间-字符串格式
    private String username;        //操作者用户名
    private String ip;              //访问ip
    private String url;             //访问资源url
    private Long execution_time;    //执行时长
    private String method;          //访问方法

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public Date getVisit_time() {
        return visit_time;
    }

    public void setVisit_time(Date visit_time) {
        this.visit_time = visit_time;
    }

    public String getVisit_timeStr() {
        if (visit_time != null) {
            visit_timeStr = DateUtils.date2String(visit_time, "yyyy-MM-dd HH-mm-ss");
        }
        return visit_timeStr;
    }

    public void setVisit_timeStr(String visit_timeStr) {
        this.visit_timeStr = visit_timeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getExecution_time() {
        return execution_time;
    }

    public void setExecution_time(Long execution_time) {
        this.execution_time = execution_time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id='" + lid + '\'' +
                ", visit_time=" + visit_time +
                ", visit_timeStr='" + visit_timeStr + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", url='" + url + '\'' +
                ", execution_time=" + execution_time +
                ", method='" + method + '\'' +
                '}';
    }
}
