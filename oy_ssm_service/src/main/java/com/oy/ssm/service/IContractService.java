package com.oy.ssm.service;

import com.oy.ssm.domain.Contract;

import java.util.List;

public interface IContractService {

    //查询所有合同
    List<Contract> findAll(Integer pageNum,Integer pageSize);

    /**
     * 添加新的合同
     * @param contract
     */
    void add(Contract contract) throws Exception;

    //删除合同
    void delete(Long cid) throws Exception;

    List<Contract> findOne(Integer pageNum, Integer pageSize, Long uid);
}
