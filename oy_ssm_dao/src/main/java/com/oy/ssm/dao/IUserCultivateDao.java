package com.oy.ssm.dao;


import com.oy.ssm.domain.Cultivate;
import com.oy.ssm.domain.UserCultivate;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserCultivateDao {

    //查询培训人员
    @Select("select * from tb_user where uid in( select uid from tb_user_cultivate where cul_id=#{cul_id})")
    @Results({
            @Result(id = true, property = "uid", column = "uid"),
            @Result(property = "username", column = "username"),
            @Result(property = "uname", column = "uname"),
            @Result(property = "createTime", column = "createTime"),
            @Result(property = "departmentAndPositionList", column = "uid",javaType = java.util.List.class,many = @Many(select="com.oy.ssm.dao.IDepartmentAndPositionDao.findByUid"))    })
    List<UserInfo> findUsers(Long cul_id);

    //查询未参与培训的人员
    @Select("select * from tb_user where uid not in( select uid from tb_user_cultivate where cul_id=#{cul_id})")
    List<UserInfo> findOtherUsers(Long cul_id);

    //根据uid查询用户参与的培训
    @Select("select * from tb_user_cultivate where uid=#{uid} order by uc_id desc")
    @Results({
            @Result(id = true,column = "uc_id",property = "uc_id"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "cul_id",column = "cul_id"),
            @Result(property = "cultivate",column = "cul_id",javaType = Cultivate.class,one = @One(select = "com.oy.ssm.dao.ICultivateDao.findOne"))
    })
    List<UserCultivate> findByUid(Long uid);

    //增加培训人员
    @Insert("insert into tb_user_cultivate(uid,cul_id) values(#{uid},#{cul_id})")
    void add(@Param("uid") Long uid, @Param("cul_id") Long cul_id) throws Exception;

    //删除培训人员
    @Delete("delete from tb_user_cultivate where uid=#{uid} and cul_id=#{cul_id}")
    void delete(@Param("uid") Long uid, @Param("cul_id") Long cul_id) throws Exception;
}

