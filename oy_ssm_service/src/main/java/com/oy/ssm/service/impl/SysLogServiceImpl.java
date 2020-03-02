package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.ISysLogDao;
import com.oy.ssm.domain.SysLog;
import com.oy.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    //返回日志信息列表
    public List<SysLog> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sysLogDao.findAll();
    }

    @Override
    public void add(SysLog sysLog) {
        sysLogDao.add(sysLog);
    }
}
