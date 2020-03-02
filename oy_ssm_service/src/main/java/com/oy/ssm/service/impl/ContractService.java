package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IContractDao;
import com.oy.ssm.domain.Contract;
import com.oy.ssm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {

    @Autowired
    private IContractDao contractDao;

    @Override
    public List<Contract> findAll(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return contractDao.findAll();
    }

    @Override
    public void add(Contract contract) throws Exception {
        contractDao.add(contract);
    }

    @Override
    public void delete(Long cid) throws Exception {
        contractDao.delete(cid);
    }

    @Override
    public List<Contract> findOne(Integer pageNum, Integer pageSize, Long uid) {
        PageHelper.startPage(pageNum,pageSize);
        return contractDao.findByUid(uid);
    }
}
