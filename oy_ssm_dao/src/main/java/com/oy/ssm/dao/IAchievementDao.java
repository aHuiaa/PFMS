package com.oy.ssm.dao;

import com.oy.ssm.domain.Achievement;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IAchievementDao {

    //查询所有奖项
    @Select("select * from tb_achievement")
    List<Achievement> findAll();

    //根据ach_id查询奖项
    @Select("select * from tb_achievement where ach_id=#{ach_id}")
    Achievement findById(Long ach_id);

    //增加奖项
    @Insert("insert into tb_achievement(ach_name,description) values(#{ach_name},#{description})")
    void add(Achievement achievement) throws Exception;

    //从中间表中删除关联
    @Delete("delete from tb_achievement_opinion where ach_id=#{ach_id}")
    void deleteRelation(Long ach_id) throws Exception;

    //删除奖项
    @Delete("delete from tb_achievement where ach_id=#{ach_id}")
    void delete(Long ach_id) throws Exception;

    //修改奖项信息
    @Update("update tb_achievement set ach_name=#{ach_name},description=#{description} where ach_id=#{ach_id}")
    void update(Achievement achievement) throws Exception;
}
