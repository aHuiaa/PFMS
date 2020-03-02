package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserFile {
    //档案的ID
    private Long fid;
    //对应用户的ID
    private Long uid;
    //性别
    private String gender;
    //民族
    private String people;
    //生日
    @DateTimeFormat(pattern = "yyyy年MM月dd日")
    private Date birthday;
    private String birthdayStr;
    //身份证号码
    private String id;
    //政治面貌
    private String politics;
    //婚姻状况
    private String marital_status;
    //学历
    private String education;
    //毕业学校
    private String school;
    //专业
    private String specialty;
    //户口地址
    private String hk_adr;
    //籍贯
    private String census_register;
    //户口类型
    private String hk_type;
    //家庭住址
    private String address;
    //邮政编码
    private String postcode;
    //聘用的形式
    private String source;
    //用户实体
    private UserInfo userInfo;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBirthdayStr() {
        if (birthday != null){
            return DateUtils.date2String(birthday,"yyyy年MM月dd日");
        }
        return "";
    }

    public void setBirthdayStr(String birthdayStr) {
        this.birthdayStr = birthdayStr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPolitics() {
        return politics;
    }

    public void setPolitics(String politics) {
        this.politics = politics;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getHk_adr() {
        return hk_adr;
    }

    public void setHk_adr(String hk_adr) {
        this.hk_adr = hk_adr;
    }

    public String getCensus_register() {
        return census_register;
    }

    public void setCensus_register(String census_register) {
        this.census_register = census_register;
    }

    public String getHk_type() {
        return hk_type;
    }

    public void setHk_type(String hk_type) {
        this.hk_type = hk_type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }


    @Override
    public String toString() {
        return "UserFile{" +
                "fid=" + fid +
                ", uid=" + uid +
                ", userInfo=" + userInfo +
                ", gender='" + gender + '\'' +
                ", people='" + people + '\'' +
                ", birthday=" + birthday +
                ", birthdayStr=" + birthdayStr +
                ", id='" + id + '\'' +
                ", politics='" + politics + '\'' +
                ", marital_status='" + marital_status + '\'' +
                ", education='" + education + '\'' +
                ", school='" + school + '\'' +
                ", specialty='" + specialty + '\'' +
                ", hk_adr='" + hk_adr + '\'' +
                ", census_register='" + census_register + '\'' +
                ", hk_type='" + hk_type + '\'' +
                ", address='" + address + '\'' +
                ", postcode='" + postcode + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
