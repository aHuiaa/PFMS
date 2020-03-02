package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IDepartmentAndPositionDao;
import com.oy.ssm.domain.DepartmentAndPosition;
import com.oy.ssm.service.IDepartmentAndPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class DepartmentAndPositionServiceImpl implements IDepartmentAndPositionService {

    @Autowired
    private IDepartmentAndPositionDao departmentAndPositionDao;

    @Override
    public List<DepartmentAndPosition> findOther(Integer pageNum, Integer pageSize, Long uid) {
        PageHelper.startPage(pageNum,pageSize);
        return departmentAndPositionDao.findOther(uid);
    }

    @Override
    public void addOtherDP(Long uid, String[] dpidList, Date create_time) throws Exception {
        for (String dpid:dpidList){
            departmentAndPositionDao.addOtherDP(uid,Long.valueOf(dpid),create_time);
        }
    }

    @Override
    public void deleteDP(Long uid, Long dpid) throws Exception {
        departmentAndPositionDao.deleteDP(uid,dpid);
    }
}
