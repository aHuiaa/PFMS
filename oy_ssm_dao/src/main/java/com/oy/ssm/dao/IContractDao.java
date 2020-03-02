package com.oy.ssm.dao;

import com.oy.ssm.domain.Contract;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IContractDao {

    //查询所有合同
    @Select("select * from tb_contract order by uid,cid desc")
    @Results({
            @Result(id=true,property = "cid",column = "cid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "start_time",column = "start_time"),
            @Result(property = "end_time",column = "end_time"),
            @Result(property = "userInfo",column = "uid" ,javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
    })
    List<Contract> findAll();

    //添加新的合同
    @Insert("insert into tb_contract(uid,start_time,end_time,contract) " +
            "values((select uid from tb_user where username=#{userInfo.username}),#{start_time},#{end_time},#{contract})")
    void add(Contract contract) throws Exception;

    //删除合同
    @Delete("delete from tb_contract where cid = #{cid}")
    void delete(Long cid) throws Exception;

    //根据uid查询员工的合同
    @Select("select * from tb_contract where uid =#{uid} order by cid desc")
    List<Contract> findByUid(Long uid);

}
