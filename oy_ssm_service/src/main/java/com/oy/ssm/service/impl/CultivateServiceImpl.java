package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.ICultivateDao;
import com.oy.ssm.domain.Cultivate;
import com.oy.ssm.service.ICultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CultivateServiceImpl implements ICultivateService {

    @Autowired
    private ICultivateDao cultivateDao;

    @Override
    public List<Cultivate> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return cultivateDao.findAll();
    }

    @Override
    public void add(Cultivate cultivate) throws Exception {
        cultivateDao.add(cultivate);
    }

    @Override
    public void delete(Long cul_id) throws Exception {
        //先删除 用户-培训 关联
        cultivateDao.deleteRelation(cul_id);
        //再删除培训
        cultivateDao.delete(cul_id);
    }

    @Override
    public void update(Cultivate cultivate) throws Exception {
        cultivateDao.update(cultivate);
    }

    @Override
    public List<Cultivate> userCul(Integer pageNum, Integer pageSize, Long uid) {
        PageHelper.startPage(pageNum,pageSize);
        return cultivateDao.findByUid(uid);
    }
}
