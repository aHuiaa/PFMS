package com.oy.ssm.dao;

import com.oy.ssm.domain.Department;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

public interface IDepartmentDao {

    //查询所有部门
    @Select("select * from tb_department")
    @Results({
            @Result(id = true,property = "did", column = "did"),
            @Result(property = "department_name", column = "department_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "create_time", column = "create_time"),
            @Result(property = "positionList", column = "did", javaType = java.util.List.class, many = @Many(select = "com.oy.ssm.dao.IPositionDao.findPositionByDid")),
    })
    List<Department> findAll();

    /**
     * 查询单个部门信息
     * @param did 部门ID
     * @return
     */
    @Select("select * from tb_department where did=#{did}")
    Department findOne(Long did);

    //根据uid查找部门
    @Select("select * from tb_department where did in(select did from tb_user_department_position where uid = #{uid})")
    List<Department> findDepartmentByUid(Long uid);

    //修改部门信息
    @Update("update tb_department set department_name = #{department_name},description = #{description} where did = #{did}")
    void updateDepartmentInfo(Department department);

    //新增部门
    @Insert(" insert into tb_department values(null,#{department_name},#{description},#{create_time})")
    void addDepartment(Department department) throws Exception;

    /**
     * 从中间表tb_department_position删除部门所关联的职位
     * @param did 部门的ID
     */
    @Delete("delete from tb_department_position where did= #{did}")
    void deleteAllPosition(Long did);

    //删除部门
    @Delete("delete from tb_department where did = #{did}")
    void deleteDepartment(Long did);

    //给部门添加其他职位
    @Insert("insert into tb_department_position values(null,#{did},#{pid},#{create_time})")
    void addOtherPosition(@Param("did") Long did, @Param("pid") Long pid, @Param("create_time") Date create_time) throws Exception;

    //给部门删除已有职位
    @Delete("delete from tb_department_position where did=#{did} and pid=#{pid}")
    void deletePosition(@Param("did") Long did ,@Param("pid") Long pid);
}
