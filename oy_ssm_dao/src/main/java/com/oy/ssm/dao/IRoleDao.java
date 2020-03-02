package com.oy.ssm.dao;

import com.oy.ssm.domain.Role;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //查询所有角色
    @Select("select * from tb_role")
    List<Role> findAll();

    //根据uid查询拥有的角色
    @Select("select * from tb_role where rid in ( select rid from tb_user_role where uid=#{uid} )")
    List<Role> findRoleByUid(Long uid);

    //根据Rid查询角色
    @Select("select * from tb_role where rid=#{rid}")
    @Results({
            @Result(id = true, property = "rid",column="rid"),
            @Result(property="role_name", column="role_name"),
            @Result(property="permission", column="permission"),
            @Result(property="description", column="description"),
            @Result(property="create_time", column="create_time"),
            @Result(property="userInfoList", column="rid", javaType=java.util.List.class,many = @Many(select = "com.oy.ssm.dao.IUserDao.findUserInfoByRid"))
    })
    Role findRoleByRid(Long rid);


    //  通过Rid查询角色的所有用户
    @Select("select * from tb_user where uid in (select uid from tb_user_role where rid = #{rid})")
    List<UserInfo> findUserInfoByRid(Long rid);

    //根据rid、uid删除角色与用户之间的关联
    @Delete("delete from tb_user_role where uid=#{uid} and rid=#{rid}")
    void delete(@Param("rid") Long rid, @Param("uid") Long uid);

    //查询用户可以添加的其他角色
    @Select("select * from tb_role where rid not in (select rid from tb_user_role where uid=#{uid})")
    List<Role> findOrderRoleByUid(Long uid);

    //根据rid、uid添加用户与角色之间的关联
    @Insert("insert into tb_user_role values(#{uid},#{rid})")
    void addOrderRoleByUidRid(@Param("uid") Long uid,@Param("rid") Long rid);
}
