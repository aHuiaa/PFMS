package com.oy.ssm.service;

import com.oy.ssm.domain.Cultivate;

import java.util.List;

public interface ICultivateService  {

    //查询所有的培训
    List<Cultivate> findAll(Integer pageNum,Integer pageSize);

    //增加一场培训
    void add(Cultivate cultivate) throws Exception;

    //删除一场培训
    void delete(Long cul_id) throws Exception;

    //更新一场培训
    void update(Cultivate cultivate) throws Exception;

    List<Cultivate> userCul(Integer pageNum, Integer pageSize, Long uid);
}
