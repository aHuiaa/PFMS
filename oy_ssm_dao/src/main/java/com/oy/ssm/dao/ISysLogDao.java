package com.oy.ssm.dao;

import com.oy.ssm.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {

    //查询所有用户
    @Select("select * from tb_log order by lid desc")
    List<SysLog> findAll();

    @Insert("insert into tb_log(visit_time,username,ip,url,execution_time,method) values(#{visit_time},#{username},#{ip},#{url},#{execution_time},#{method})")
    void add(SysLog sysLog);
}
