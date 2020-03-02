package com.oy.ssm.service;

import com.oy.ssm.domain.DepartmentAndPosition;

import java.util.Date;
import java.util.List;

public interface IDepartmentAndPositionService {

    //通过uid查找用户可添加的部门和职位
    List<DepartmentAndPosition> findOther(Integer pageNum, Integer PageSize, Long uid);

    /**
     * 给用户添加新的职位
     * @param uid 用户ID
     * @param dpidList 部门-职位 ID字符数组
     */
    void addOtherDP(Long uid, String[] dpidList, Date create_time) throws Exception;

    /**
     * 删除用户的部门职位
     * @param uid 用户ID
     * @param dpid 要删除的部门-职位ID
     */
    void deleteDP(Long uid,Long dpid) throws Exception;
}
