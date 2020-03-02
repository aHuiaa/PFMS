package com.oy.ssm.service;

import com.oy.ssm.domain.Role;
import com.oy.ssm.domain.UserInfo;

import java.util.List;

public interface IRoleService {

    //查询所有角色
    List<Role> findAll(Integer pageNum,Integer pageSize);

    //根据rid查询角色
    Role findRoleByRid(Long rid);

    //根据rid查询用户
    List<UserInfo> findUserInfoByRid(Integer pageNum, Integer pageSize, Long rid);

    //根据rid、uid删除角色与用户之间的关联
    void delete(Long rid, String[] uidlist) throws Exception;

    //根据uid查询可以添加的角色
    List<Role> findOrderRoleByUid(Long uid);

    //根据uid，ridList添加其他角色
    void addOrderRoleByUidRid(Long uid,String[] ridList);
}
