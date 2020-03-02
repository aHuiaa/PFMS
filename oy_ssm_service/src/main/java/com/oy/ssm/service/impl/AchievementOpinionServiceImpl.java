package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IAchievementOpinionDao;
import com.oy.ssm.domain.AchievementOpinion;
import com.oy.ssm.service.IAchievementOpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AchievementOpinionServiceImpl implements IAchievementOpinionService {

    @Autowired
    private IAchievementOpinionDao achievementOpinionDao;

    @Override
    public List<AchievementOpinion> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return achievementOpinionDao.findAll();
    }
//
//    @Override
//    public List<AchievementOpinion> findByUid(Long uid) {
//        return achievementOpinionDao.findByUid(uid);
//    }

    @Override
    public void add(AchievementOpinion achievementOpinion) throws Exception {
        achievementOpinionDao.add(achievementOpinion);
    }

    @Override
    public void delete(Long oid) throws Exception {
        achievementOpinionDao.delete(oid);
    }

    @Override
    public void update(AchievementOpinion achievementOpinion) throws Exception {
        achievementOpinionDao.update(achievementOpinion);
    }

    @Override
    public List<AchievementOpinion> findRec(Integer pageNum, Integer pageSize, Long uid) {
        PageHelper.startPage(pageNum,pageSize);
        return achievementOpinionDao.findByUid(uid);
    }

    @Override
    public List<AchievementOpinion> findPass(Integer pageNum, Integer pageSize, Long uid) {
        PageHelper.startPage(pageNum,pageSize);
        return achievementOpinionDao.findPass(uid);
    }

    @Override
    public List<AchievementOpinion> findDeptRec(Integer pageNum, Integer pageSize, Long uid) {
        return achievementOpinionDao.findDeptRec(uid);
    }

    @Override
    public List<AchievementOpinion> findDeptRecY(Integer pageNum, Integer pageSize, Long uid) {
        return achievementOpinionDao.findDeptRecY(uid);
    }
}
