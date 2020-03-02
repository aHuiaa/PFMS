package com.oy.ssm.service;

import com.oy.ssm.domain.SysLog;

import java.util.List;

public interface ISysLogService {

    //查询所有日志
    List<SysLog> findAll(Integer pageNum, Integer pageSize);

    //添加日志
    void add(SysLog sysLog);
}
