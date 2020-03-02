package com.oy.ssm.service;

import com.oy.ssm.domain.Department;

import java.util.Date;
import java.util.List;

public interface IDepartmentService {

    //查询所有部门信息
    List<Department> findAll();

    //添加部门
    void add(Department department) throws Exception;

    /**
     * 删除部门
     * @param did
     * @throws Exception
     */
    void delete(Long did) throws Exception;

    /**
     *给部门关联职位
     * @param did 部门ID
     * @param pids 职位ID
     * @param create_time 添加时间
     */
    void addOtherPosition(Long did, String[] pids, Date create_time) throws Exception;

    //删除部门的职位
    void deletePosition(Long did,Long pid) throws Exception;

    //修改部门信息
    void update(Department department);
}
