package com.oy.ssm.dao;

import com.oy.ssm.domain.UserFile;
import com.oy.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUserFileDao {

    //查询所有的档案
    @Select("select * from tb_file")
    @Results({
            @Result(id = true,property = "fid",column = "fid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
    })
    List<UserFile> findAll();

    //按照fid查询档案
    @Select("select * from tb_file where fid=#{fid}")
    @Results({
            @Result(id = true,property = "fid",column = "fid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "people",column = "people"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "id",column = "id"),
            @Result(property = "politics",column = "politics"),
            @Result(property = "marital_status",column = "marital_status"),
            @Result(property = "education",column = "education"),
            @Result(property = "school",column = "school"),
            @Result(property = "specialty",column = "specialty"),
            @Result(property = "hk_adr",column = "hk_adr"),
            @Result(property = "census_register",column = "census_register"),
            @Result(property = "hk_type",column = "hk_type"),
            @Result(property = "address",column = "address"),
            @Result(property = "postcode",column = "postcode"),
            @Result(property = "source",column = "source"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
    })
    UserFile findOne(Long fid);

    //按照uid查询档案
    @Select("select * from tb_file where uid=#{uid}")
    @Results({
            @Result(id = true,property = "fid",column = "fid"),
            @Result(property = "uid",column = "uid"),
            @Result(property = "gender",column = "gender"),
            @Result(property = "people",column = "people"),
            @Result(property = "birthday",column = "birthday"),
            @Result(property = "id",column = "id"),
            @Result(property = "politics",column = "politics"),
            @Result(property = "marital_status",column = "marital_status"),
            @Result(property = "education",column = "education"),
            @Result(property = "school",column = "school"),
            @Result(property = "specialty",column = "specialty"),
            @Result(property = "hk_adr",column = "hk_adr"),
            @Result(property = "census_register",column = "census_register"),
            @Result(property = "hk_type",column = "hk_type"),
            @Result(property = "address",column = "address"),
            @Result(property = "postcode",column = "postcode"),
            @Result(property = "source",column = "source"),
            @Result(property = "userInfo",column = "uid",javaType = UserInfo.class,one = @One(select = "com.oy.ssm.dao.IUserDao.findUserByUid")),
    })
    UserFile findOneByUid(Long uid);

    //修改档案
    @Update("update tb_file set gender=#{gender},people=#{people},birthday=#{birthday},id=#{id},politics=#{politics}," +
            "marital_status=#{marital_status},education=#{education},school=#{school},specialty=#{specialty}," +
            "hk_adr=#{hk_adr},census_register=#{census_register},hk_type=#{hk_type},address=#{address},postcode=#{postcode}," +
            "source=#{source} where fid=#{fid}" )
    void update(UserFile userFile) throws Exception;

    //增加档案
    @Insert("insert into tb_file(uid,gender,people,birthday,id,politics,marital_status,education,school,specialty,hk_adr," +
            "census_register,hk_type,address,postcode,source) values((select uid from tb_user where username=#{userInfo.username}),#{gender},#{people},#{birthday},#{id},#{politics}," +
            "#{marital_status},#{education},#{school},#{specialty},#{hk_adr},#{census_register},#{hk_type},#{address}," +
            "#{postcode},#{source})")
    void add(UserFile userFile) throws Exception;

    //删除档案
    @Delete("delete from tb_file where fid=#{fid}")
    void delete(Long fid) throws Exception;

}
