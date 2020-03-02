package com.oy.ssm.service;

import com.oy.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

    //查询所有用户
    List<UserInfo> findAll(Integer pageNum,Integer pageSize);

    //根据username查询用户
    UserInfo findUserInfoByUsername(String username) throws Exception;

    //模糊查询 根据 姓名 查询用户
    List<UserInfo> findUserInfoByName(String name);

    //添加用户
    void add(UserInfo userInfo) throws Exception;

    //删除用户
    void delete(String[] uidlist) throws Exception;

    //查询用户详情
    UserInfo details(Long uid) throws Exception;

    //更新用户信息
    void update(UserInfo userInfo) throws Exception;

    //删除用户的角色
    void deleteRole(Long uid, Long rid) throws Exception;
}
