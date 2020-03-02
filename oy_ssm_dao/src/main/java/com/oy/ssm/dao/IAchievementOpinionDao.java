package com.oy.ssm.dao;

import com.oy.ssm.domain.Achievement;
import com.oy.ssm.domain.AchievementOpinion;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;


public interface IAchievementOpinionDao {

    //查询审批列表
    @Select("select * from tb_achievement_opinion order by oid desc")
    @Results({
            @Result(id = true, property = "oid",column = "oid"),
            @Result( property = "uid",column = "uid"),
            @Result( property = "ach_id",column = "ach_id"),
            @Result( property = "reason",column = "reason"),
            @Result( property = "opinion",column = "opinion"),
            @Result( property = "approver",column = "approver"),
            @Result( property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
            @Result( property = "achievement",column = "ach_id",javaType = Achievement.class,one = @One(select = "com.oy.ssm.dao.IAchievementDao.findById"))
    })
    List<AchievementOpinion> findAll();

    //根据uid查询用户的申请信息
    @Select("select * from tb_achievement_opinion where uid = #{uid} order by oid desc")
    @Results({
            @Result(id = true, property = "oid",column = "oid"),
            @Result( property = "uid",column = "uid"),
            @Result( property = "ach_id",column = "ach_id"),
            @Result( property = "reason",column = "reason"),
            @Result( property = "opinion",column = "opinion"),
            @Result( property = "approver",column = "approver"),
            @Result( property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
            @Result( property = "achievement",column = "ach_id",javaType = Achievement.class,one = @One(select = "com.oy.ssm.dao.IAchievementDao.findById"))
    })
    List<AchievementOpinion> findByUid(Long uid);

    //查询用户申请通过的记录
    @Select("select * from tb_achievement_opinion where opinion='通过' and uid = #{uid} order by oid desc")
    @Results({
            @Result(id = true, property = "oid",column = "oid"),
            @Result( property = "uid",column = "uid"),
            @Result( property = "ach_id",column = "ach_id"),
            @Result( property = "reason",column = "reason"),
            @Result( property = "opinion",column = "opinion"),
            @Result( property = "approver",column = "approver"),
            @Result( property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
            @Result( property = "achievement",column = "ach_id",javaType = Achievement.class,one = @One(select = "com.oy.ssm.dao.IAchievementDao.findById"))
    })
    List<AchievementOpinion> findPass(Long uid);

    //添加申请信息
    @Insert("insert into tb_achievement_opinion(uid,ach_id,reason,a_time) values" +
            "((select uid from tb_user where username=#{userInfo.username})," +
            "(select ach_id from tb_achievement where ach_name=#{achievement.ach_name} )," +
            "#{reason},#{a_time})")
    void add(AchievementOpinion achievementOpinion) throws Exception;

    //删除申请信息
    @Delete("delete from tb_achievement_opinion where oid=#{oid}")
    void delete(Long oid) throws Exception;

    //修改审批信息
    @Update("update tb_achievement_opinion set opinion=#{opinion},opinion_content=#{opinion_content},approver=(select uname from tb_user where uid =#{userInfo.uid}),o_time=#{o_time} where oid=#{oid}")
    void update(AchievementOpinion achievementOpinion) throws Exception;

    //查询部门未审批的员工荣誉申请记录
    @Select("select * from tb_achievement_opinion where opinion is null and  uid in " +
            "(select uid from tb_user_department_position where dpid in " +
            "(select dpid from tb_user_department_position where uid = #{uid})) order by o_time desc")
    @Results({
            @Result(id = true, property = "oid",column = "oid"),
            @Result( property = "uid",column = "uid"),
            @Result( property = "ach_id",column = "ach_id"),
            @Result( property = "reason",column = "reason"),
            @Result( property = "opinion",column = "opinion"),
            @Result( property = "approver",column = "approver"),
            @Result( property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
            @Result( property = "achievement",column = "ach_id",javaType = Achievement.class,one = @One(select = "com.oy.ssm.dao.IAchievementDao.findById"))
    })
    List<AchievementOpinion> findDeptRec(Long uid);

    //查询部门已审批的员工荣誉申请记录
    @Select("select * from tb_achievement_opinion where opinion is not null and  uid in " +
            "(select uid from tb_user_department_position where dpid in " +
            "(select dpid from tb_user_department_position where uid = #{uid})) order by o_time desc")
    @Results({
            @Result(id = true, property = "oid",column = "oid"),
            @Result( property = "uid",column = "uid"),
            @Result( property = "ach_id",column = "ach_id"),
            @Result( property = "reason",column = "reason"),
            @Result( property = "opinion",column = "opinion"),
            @Result( property = "approver",column = "approver"),
            @Result( property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
            @Result( property = "achievement",column = "ach_id",javaType = Achievement.class,one = @One(select = "com.oy.ssm.dao.IAchievementDao.findById"))
    })
    List<AchievementOpinion> findDeptRecY(Long uid);
}
