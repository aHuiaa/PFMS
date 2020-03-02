package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IAchievementDao;
import com.oy.ssm.domain.Achievement;
import com.oy.ssm.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementServiceImpl implements IAchievementService {

    @Autowired
    private IAchievementDao achievementDao;

    @Override
    public List<Achievement> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return achievementDao.findAll();
    }

    @Override
    public void add(Achievement achievement) throws Exception {
        achievementDao.add(achievement);
    }

    @Override
    public void delete(Long ach_id) throws Exception {
        achievementDao.deleteRelation(ach_id);
        achievementDao.delete(ach_id);
    }

    @Override
    public void update(Achievement achievement) throws Exception {
        achievementDao.update(achievement);
    }
}
