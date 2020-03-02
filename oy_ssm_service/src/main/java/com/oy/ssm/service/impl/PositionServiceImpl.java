package com.oy.ssm.service.impl;

import com.oy.ssm.dao.IPositionDao;
import com.oy.ssm.domain.Position;
import com.oy.ssm.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionDao positionDao;

    @Override
    public List<Position> findAll() {
        return positionDao.findAll();
    }

    @Override
    public List<Position> findOtherPositionByDid(Long did) {
        return positionDao.findOtherPositionByDid(did);
    }

    @Override
    public void add(Position position) throws Exception {
        positionDao.addPosition(position);
    }

    @Override
    public void delete(Long pid) throws Exception {
        //先删除部门与职位之间的联系
        positionDao.deletePositionRelation(pid);
        //再删除职位
        positionDao.deletePosition(pid);
    }

    @Override
    public void update(Position position) throws Exception {
        positionDao.updatePosition(position);
    }
}
