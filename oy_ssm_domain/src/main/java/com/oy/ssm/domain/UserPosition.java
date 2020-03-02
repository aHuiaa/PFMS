package com.oy.ssm.domain;

import java.util.Date;

public class UserPosition {

    private Long uid;

    private Long did;

    private Long pid;

    private Date createTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "UserPosition{" +
                "uid=" + uid +
                ", did=" + did +
                ", pid=" + pid +
                ", createTime=" + createTime +
                '}';
    }
}
