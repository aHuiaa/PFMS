package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IUserCultivateDao;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IUserCultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCultivateServiceImpl implements IUserCultivateService {

    @Autowired
    private IUserCultivateDao userCultivateDao;

    @Override
    public List<UserInfo> findUsers(Long cul_id,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userCultivateDao.findUsers(cul_id);
    }

    @Override
    public List<UserInfo> findOtherUsers(Long cul_id) {
        return userCultivateDao.findOtherUsers(cul_id);
    }

    @Override
    public void add(String[] uidList, Long cul_id) throws Exception {
        for (String uid:uidList) {
            userCultivateDao.add(Long.valueOf(uid),cul_id);
        }
    }

    @Override
    public void delete(String[] uidList, Long cul_id) throws Exception {
        for (String uid:uidList) {
            userCultivateDao.delete(Long.valueOf(uid),cul_id);
        }
    }
}
