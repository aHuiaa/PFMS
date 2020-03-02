package com.oy.ssm.dao;

import com.oy.ssm.domain.Cultivate;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ICultivateDao {

    //查询所有的培训
    @Select("select * from tb_cultivate")
    List<Cultivate> findAll();

    //根据cul_id查询一场培训
    @Select("select * from tb_cultivate where cul_id=#{cul_id}")
    Cultivate findOne(Long cul_id);

    //增加一场培训
    @Insert("insert into tb_cultivate(cul_name,content,address,start_time,end_time) values(#{cul_name},#{content},#{address},#{start_time},#{end_time})")
    void add(Cultivate cultivate) throws Exception;

    //删除关联
    @Delete("delete from tb_user_cultivate where cul_id = #{cul_id}")
    void deleteRelation(Long cul_id);

    //删除一场培训
    @Delete("delete from tb_cultivate where cul_id=#{cul_id}")
    void delete(Long cul_id) throws Exception;

    //更新一场培训
    @Update("update tb_cultivate set cul_name=#{cul_name},content=#{content},start_time=#{start_time},end_time=#{end_time} where cul_id=#{cul_id}")
    void update(Cultivate cultivate) throws Exception;

    @Select("select * from tb_cultivate where cul_id in (select cul_id from tb_user_cultivate where uid=#{uid})")
    List<Cultivate> findByUid(Long uid);
}
