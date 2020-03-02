package com.oy.ssm.service;

import com.oy.ssm.domain.AchievementOpinion;

import java.util.List;

public interface IAchievementOpinionService {
    //查询审批列表
    List<AchievementOpinion> findAll(Integer pageNum,Integer pageSize);
//
//    //查询用户的申请信息
//    List<AchievementOpinion> findByUid(Long uid);

    //添加申请信息
    void add(AchievementOpinion achievementOpinion) throws Exception;

    //删除申请信息
    void delete(Long oid) throws Exception;

    //修改审批信息
    void update(AchievementOpinion achievementOpinion) throws Exception;

    //查询用户的荣誉申请记录
    List<AchievementOpinion> findRec(Integer pageNum, Integer pageSize, Long uid);

    /**
     * 查询用户已通过的荣誉申请记录
     * @param pageNum
     * @param pageSize
     * @param uid 用户的ID
     * @return
     */
    List<AchievementOpinion> findPass(Integer pageNum, Integer pageSize, Long uid);

    /**
     * 查询部门未审批的员工荣誉申请记录
     * @param pageNum
     * @param pageSize
     * @param uid 部门负责人的uid
     * @return
     */
    List<AchievementOpinion> findDeptRec(Integer pageNum, Integer pageSize, Long uid);

    /**
     * 查询部门已审批的员工荣誉申请记录
     * @param pageNum
     * @param pageSize
     * @param uid 部门负责人的uid
     * @return
     */
    List<AchievementOpinion> findDeptRecY(Integer pageNum, Integer pageSize, Long uid);
}
