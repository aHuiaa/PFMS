package com.oy.ssm.dao;

import com.oy.ssm.domain.UserFile;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface IUserDao {

    //根据用户名查询用户
    @Select("select * from tb_user where username = #{username}")
    @Results({
            @Result(id = true, property = "uid", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "psw", column = "psw"),
            @Result(property = "uname", column = "uname"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "office", column = "office"),
            @Result(property = "status", column = "status"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "roleList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IRoleDao.findRoleByUid")),
            @Result(property = "departmentAndPositionList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IDepartmentAndPositionDao.findByUid")),
            @Result(property = "contractList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IContractDao.findByUid")),
            @Result(property = "userCultivateList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IUserCultivateDao.findByUid")),
            @Result(property = "achievementOpinionList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IAchievementOpinionDao.findPass")),
            @Result(property = "userFile", column = "uid",javaType = UserFile.class,one = @One(select="com.oy.ssm.dao.IUserFileDao.findOneByUid"))
    })
    UserInfo findUserByUsername(String username)throws Exception;

    //查询所有用户
    @Select("select * from tb_user")
    List<UserInfo> findAll();

    //模糊查询 根据 姓名 查询用户
    @Select("select * from tb_user where name like '%#{name}%' ")
    List<UserInfo> findUserInfoByName(String name);

    //根据 部门 查询用户
    @Select("select * from tb_user where uid in(select uid from tb_user_department_position where did = #{did})")
    List<UserInfo> findUserInfoByDid(Long did);

    //通过Rid查询角色的所有用户
    @Select("select * from tb_user where uid in (select uid from tb_user_role where rid = #{rid})")
    List<UserInfo> findUserInfoByRid(Long rid);

    //根据用户UID查询
    @Select("select * from tb_user where uid = #{uid}")
    @Results({
            @Result(id = true, property = "uid", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "psw", column = "psw"),
            @Result(property = "uname", column = "uname"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "office", column = "office"),
            @Result(property = "status", column = "status"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "roleList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IRoleDao.findRoleByUid")),
            @Result(property = "departmentAndPositionList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IDepartmentAndPositionDao.findByUid")),
            @Result(property = "contractList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IContractDao.findByUid")),
            @Result(property = "userCultivateList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IUserCultivateDao.findByUid")),
            @Result(property = "achievementOpinionList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IAchievementOpinionDao.findPass"))
    })
    UserInfo findUserByUid(Long uid)throws Exception;

    //添加用户
    @Insert("insert into tb_user(username,psw,uname,phone,email,office,status,create_time) values(#{username},#{psw},#{uname},#{phone},#{email},#{office},#{status},#{create_time})")
    void add(UserInfo userInfo) throws Exception;

    //根据用户ID删除用户
    @Delete("delete from tb_user where uid=#{uid}")
    void deleteById(Long uid) throws Exception;

    //更新用户的信息
    @Update("update tb_user set psw=#{psw}, uname=#{uname}, phone=#{phone} , email =#{email}, office=#{office} , status=#{status} where uid=#{uid}")
    void updateInfo(UserInfo userInfo) throws Exception;

    //更改用户密码
    @Update("update tb_user set psw=#{psw} where uid=#{uid}")
    void updatePsw(Long uid) throws Exception;

    //根据nid查询公告的发布人
    @Select("select * from tb_user where uid =(select uid from tb_user_notice where nid=#{nid})")
    UserInfo findUserByNid(Long nid);

    //删除用户的角色
    @Delete("delete from tb_user_role where uid=#{uid} and rid=#{rid}")
    void deleteRole(@Param("uid") Long uid, @Param("rid") Long rid)throws Exception;
}
