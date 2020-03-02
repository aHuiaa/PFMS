package com.oy.ssm.dao;

import com.oy.ssm.domain.Notice;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface INoticeDao {

    //查询所有公告
    @Select("select * from tb_notice order by nid desc")
    @Results({
            @Result(id = true,property = "nid",column = "nid"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "userInfo",column = "nid",javaType = UserInfo.class,one = @One(select ="com.oy.ssm.dao.IUserDao.findUserByNid")),
    })
    List<Notice> findAll();

    //新增公告
    @SelectKey(statement ="select LAST_INSERT_ID()" , keyProperty = "nid", keyColumn = "nid", before =false , resultType = java.lang.Long.class )
    @Insert("insert into tb_notice values(null,#{title},#{content},#{create_time})")
    void add(Notice notice) throws Exception;

    //增加公告与人员的联系，即谁添加的公告
    @Insert("insert into tb_user_notice values(#{uid},#{nid})")
    void addRelation(@Param("uid") Long uid,@Param("nid") Long nid) throws Exception;

    //根据公告ID删除公告与人员之间的联系
    @Delete("delete from tb_user_notice where nid=#{nid}")
    void deleteRelation(Long nid) throws Exception;

    //根据公告ID删除公告
    @Delete("delete from tb_notice where nid=#{nid}")
    void delete(Long nid) throws Exception;

    //查询最新的公告
    @Select("select * from tb_notice order by nid desc limit 0,1")
    @Results({
            @Result(id = true,property = "nid",column = "nid"),
            @Result(property = "title",column = "title"),
            @Result(property = "content",column = "content"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "userInfo",column = "nid",javaType = UserInfo.class,one = @One(select ="com.oy.ssm.dao.IUserDao.findUserByNid")),
    })
    Notice findNew();
}
