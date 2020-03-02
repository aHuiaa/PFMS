package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IRoleDao;
import com.oy.ssm.domain.Role;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;

    @Override
    public List<Role> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return roleDao.findAll();
    }

    @Override
    public Role findRoleByRid(Long rid) {
        return roleDao.findRoleByRid(rid);
    }

    @Override
    public List<UserInfo> findUserInfoByRid(Integer pageNum, Integer pageSize, Long rid) {
        PageHelper.startPage(pageNum,pageSize);
        return roleDao.findUserInfoByRid(rid);
    }

    @Override
    public void delete(Long rid, String[] uidList) throws Exception {
        for (String uid:uidList) {
            roleDao.delete(rid, Long.valueOf(uid));
        }
    }

    @Override
    public List<Role> findOrderRoleByUid(Long uid) {
        return roleDao.findOrderRoleByUid(uid);
    }

    @Override
    public void addOrderRoleByUidRid(Long uid, String[] ridList) {

        for (String rid : ridList){
            roleDao.addOrderRoleByUidRid(uid,Long.valueOf(rid));
        }

    }
}
