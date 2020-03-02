package com.oy.ssm.domain;

import com.oy.ssm.utils.DateUtils;
import java.util.Date;
import java.util.List;

//用户表
public class UserInfo {

    private Long uid;  //用户的ID

    private String username; // 用户名

    private String psw; //密码

    private String uname;  //姓名

    private String phone;  //手机号码

    private String email; // 邮箱

    private String office; // 办公地点

    private Integer status;   //状态:0未激活，1已激活

    private String statusStr; //状态

    private Date create_time; //创建时间

    private String create_timeStr; //创建时间

    private List<Role> roleList; //角色列表，用户的角色

    private List<Department> departmentList;  //用户所属的部门

    private List<Position> positionList;  //用户的职位

    private List<DepartmentAndPosition> departmentAndPositionList; //用户的部门职位

    private List<Contract> contractList; //用户的合同列表

    private List<UserCultivate> userCultivateList; //用户的培训记录

    private List<AchievementOpinion> achievementOpinionList; //用户的获奖记录

    private UserFile userFile;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusStr() {

        if (status == 0){
            statusStr = "未开启";
        }else {
            statusStr = "开启";
        }

        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCreate_timeStr() {
        return DateUtils.date2String(create_time,"yyyy-MM-dd");
    }

    public void setCreate_timeStr(String create_timeStr) {
        this.create_timeStr = create_timeStr;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public List<DepartmentAndPosition> getDepartmentAndPositionList() {
        return departmentAndPositionList;
    }

    public void setDepartmentAndPositionList(List<DepartmentAndPosition> departmentAndPositionList) {
        this.departmentAndPositionList = departmentAndPositionList;
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public List<UserCultivate> getUserCultivateList() {
        return userCultivateList;
    }

    public void setUserCultivateList(List<UserCultivate> userCultivateList) {
        this.userCultivateList = userCultivateList;
    }

    public List<AchievementOpinion> getAchievementOpinionList() {
        return achievementOpinionList;
    }

    public void setAchievementOpinionList(List<AchievementOpinion> achievementOpinionList) {
        this.achievementOpinionList = achievementOpinionList;
    }

    public UserFile getUserFile() {
        return userFile;
    }

    public void setUserFile(UserFile userFile) {
        this.userFile = userFile;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", psw='" + psw + '\'' +
                ", uname='" + uname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", office='" + office + '\'' +
                ", status=" + status +
                ", statusStr='" + statusStr + '\'' +
                ", create_time=" + create_time +
                ", create_timeStr='" + create_timeStr + '\'' +
                ", roleList=" + roleList +
                ", departmentList=" + departmentList +
                ", positionList=" + positionList +
                ", departmentAndPositionList=" + departmentAndPositionList +
                ", contractList=" + contractList +
                ", userCultivateList=" + userCultivateList +
                ", achievementOpinionList=" + achievementOpinionList +
                ", userFile=" + userFile +
                '}';
    }
}
