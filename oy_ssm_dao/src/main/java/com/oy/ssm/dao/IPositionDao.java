package com.oy.ssm.dao;

import com.oy.ssm.domain.Position;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IPositionDao {

    //查询所有职位
    @Select("select * from tb_position")
    List<Position> findAll();

    /**
     * 查找单个职位信息
     * @param pid 职位ID
     * @return
     */
    @Select("select * from tb_position where pid=#{pid}")
    List<Position> findOne(Long pid);

    //根据uid查找职位
    @Select("select * from tb_position where pid in(select pid from tb_user_position where )")
    List<Position> findPositionByUid(Long uid);

    //根据部门did查找职位
    @Select("select * from tb_position where pid in( select pid from tb_department_position where did = #{did})")
    List<Position> findPositionByDid(Long did);

    /**
     * 根据部门查找可添加的职位
     * @param did 部门ID
     * @return
     */
    @Select("select * from tb_position where pid not in( select pid from tb_department_position where did = #{did})")
    List<Position> findOtherPositionByDid(Long did);

    //更改职位信息
    @Update("update tb_position set position_name = #{position_name},description = #{description} where pid = #{pid}")
    void updatePosition(Position position);

    /**
     * 新增职位
     * @param position
     */
    @Insert("insert into tb_position values(null,#{position_name},#{description},create_time)")
    void addPosition(Position position) throws Exception;

    /**
     * 根据pid删除职位与部门之间的联系
     * @param pid
     * @throws Exception
     */
    @Delete("delete from tb_department_position where pid = #{pid}")
    void deletePositionRelation(Long pid) throws Exception;

    /**
     * 删除职位
     * @param pid 职位的ID
     */
    @Delete("delete from tb_position where pid = #{pid}")
    void deletePosition(Long pid) throws Exception;


}
