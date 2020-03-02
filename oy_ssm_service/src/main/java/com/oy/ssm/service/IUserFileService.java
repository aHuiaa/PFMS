package com.oy.ssm.service;

import com.oy.ssm.domain.UserFile;

import java.util.List;

public interface IUserFileService {

    //查询所有档案
    List<UserFile> findAll(Integer pageNum,Integer pageSize);

    //根据档案oid查询单个档案
    UserFile findOne(Long fid);

    //增加用户档案
    void add(UserFile userFile) throws Exception;

    //删除用户档案
    void delete(Long fid) throws Exception;

    //更新用户档案信息
    void update(UserFile userFile) throws Exception;

    UserFile details(Long uid);
}
