package com.oy.ssm.service;

import com.oy.ssm.domain.Notice;

import java.util.List;

public interface INoticeService {

    //查询所有公告
    List<Notice> findAll(Integer pageNum, Integer pageSize);

    /**
     * 增加新的公告
     * @param notice 公告对象
     * @param uid  用户ID
     * @throws Exception
     */
    void add(Notice notice,Long uid) throws Exception;

    //根据公告ID删除公告
    void delete(Long nid) throws Exception;

    /**
     * 查询最新的公告
     * @return
     */
    Notice findNew();
}
