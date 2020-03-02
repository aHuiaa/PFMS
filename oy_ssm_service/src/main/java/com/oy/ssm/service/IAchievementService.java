package com.oy.ssm.service;

import com.oy.ssm.domain.Achievement;

import java.util.List;

public interface IAchievementService {

    //查询所有奖项
    List<Achievement> findAll(Integer pageNum,Integer pageSize);

    //增加奖项
    void add(Achievement achievement) throws Exception;

    //删除奖项
    void delete(Long ach_id) throws Exception;

    //修改奖项信息
    void update(Achievement achievement) throws Exception;
}
