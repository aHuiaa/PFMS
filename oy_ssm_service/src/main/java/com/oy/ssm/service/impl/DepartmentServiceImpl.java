package com.oy.ssm.service.impl;

import com.oy.ssm.dao.IDepartmentDao;
import com.oy.ssm.domain.Department;
import com.oy.ssm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentDao departmentDao;

    @Override
    public List<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void add(Department department) throws Exception {
        departmentDao.addDepartment(department);
    }

    @Override
    public void delete(Long did) throws Exception {
        //从中间表删除部门与职位之间的关联
        departmentDao.deleteAllPosition(did);
        //删除部门
        departmentDao.deleteDepartment(did);
    }

    @Override
    public void addOtherPosition(Long did, String[] pids, Date create_time) throws Exception {
        for (String pid:pids) {
            departmentDao.addOtherPosition(did, Long.valueOf(pid), create_time);
        }
    }

    @Override
    public void deletePosition(Long did, Long pid) throws Exception {
        departmentDao.deletePosition(did,pid);
    }

    @Override
    public void update(Department department) {
        departmentDao.updateDepartmentInfo(department);
    }
}
