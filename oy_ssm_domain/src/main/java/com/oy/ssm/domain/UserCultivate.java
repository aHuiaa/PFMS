package com.oy.ssm.domain;

public class UserCultivate {

    private  Long uc_id;
    private Long uid;
    private Long cul_id;
    private UserInfo userInfo;
    private Cultivate cultivate;

    public Long getCu_id() {
        return uc_id;
    }

    public void setCu_id(Long uc_id) {
        this.uc_id = uc_id;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getCul_id() {
        return cul_id;
    }

    public void setCul_id(Long cul_id) {
        this.cul_id = cul_id;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Cultivate getCultivate() {
        return cultivate;
    }

    public void setCultivate(Cultivate cultivate) {
        this.cultivate = cultivate;
    }

    @Override
    public String toString() {
        return "UserCultivate{" +
                "cu_id=" + uc_id +
                ", uid=" + uid +
                ", cul_id=" + cul_id +
                ", userInfo=" + userInfo +
                ", cultivate=" + cultivate +
                '}';
    }
}
