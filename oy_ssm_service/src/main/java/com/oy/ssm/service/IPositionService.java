package com.oy.ssm.service;

import com.oy.ssm.domain.Position;

import java.util.List;

public interface IPositionService {

    /**
     * 查询所有职位
     * @return
     */
    List<Position> findAll();

    /**
     * 根据部门ID查询可添加的职位
     * @param did
     * @return
     */
    List<Position> findOtherPositionByDid(Long did);

    /**
     * 添加新的职位
     * @param position
     */
    void add(Position position) throws Exception;

    /**
     * 删除职位
     * @param pid
     * @throws Exception
     */
    void delete(Long pid) throws Exception;

    void update(Position position) throws Exception;

}
