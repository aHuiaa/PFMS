package com.oy.ssm.dao;

import com.oy.ssm.domain.Department;
import com.oy.ssm.domain.DepartmentAndPosition;
import com.oy.ssm.domain.Position;
import org.apache.ibatis.annotations.*;
import java.util.Date;
import java.util.List;


public interface IDepartmentAndPositionDao {

    //通过uid查找所在的部门和职位
    @Select("select * from tb_department_position where dpid in " +
            "(select dpid from tb_user_department_position where uid=#{uid}) " +
            "order by dpid desc")
    @Results({
            @Result(id=true,property = "dpid",column = "dpid"),
            @Result(property = "did",column = "did"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "department",column = "did",javaType = Department.class,one=@One(select = "com.oy.ssm.dao.IDepartmentDao.findOne")),
            @Result(property = "position",column = "pid",javaType = Position.class,one=@One(select = "com.oy.ssm.dao.IPositionDao.findOne"))
    })
    List<DepartmentAndPosition> findByUid(Long uid);

    //通过uid查找用户可添加的部门和职位
    @Select("select * from tb_department_position where dpid not in " +
            "(select dpid from tb_user_department_position where uid=#{uid}) " +
            "order by did desc")
    @Results({
            @Result(id=true,property = "dpid",column = "dpid"),
            @Result(property = "did",column = "did"),
            @Result(property = "pid",column = "pid"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "department",column = "did",javaType = Department.class,one=@One(select = "com.oy.ssm.dao.IDepartmentDao.findOne")),
            @Result(property = "position",column = "pid",javaType = Position.class,one=@One(select = "com.oy.ssm.dao.IPositionDao.findOne"))
    })
    List<DepartmentAndPosition> findOther(Long uid);

    /**
     *给用户添加新的部门职位信息
     * @param uid 用户ID
     * @param dpid 部门-职位 ID
     * @param create_time 添加的时间
     */
    @Insert("insert into tb_user_department_position values(#{uid},#{dpid},#{create_time})")
    void addOtherDP(@Param("uid") Long uid, @Param("dpid") Long dpid, @Param("create_time") Date create_time) throws Exception;

    @Delete("delete from tb_user_department_position where uid=#{uid} and dpid=#{dpid} ")
    void deleteDP(@Param("uid") Long uid, @Param("dpid") Long dpid) throws Exception;
}
