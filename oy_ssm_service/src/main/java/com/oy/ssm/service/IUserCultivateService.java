package com.oy.ssm.service;

import com.oy.ssm.domain.UserInfo;

import java.util.List;

public interface IUserCultivateService {

    //查询培训的人员
    List<UserInfo> findUsers(Long cul_id,Integer pageNum,Integer pageSize);

    //查询未培训的人员
    List<UserInfo> findOtherUsers(Long cul_id);

    //增加培训人员
    void add(String[] uidList, Long cul_id) throws Exception;

    void delete(String[] uidList, Long cul_id) throws Exception;


}
