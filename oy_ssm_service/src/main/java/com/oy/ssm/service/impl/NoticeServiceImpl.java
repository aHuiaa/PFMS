package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.INoticeDao;
import com.oy.ssm.domain.Notice;
import com.oy.ssm.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements INoticeService {

    @Autowired
    private INoticeDao noticeDao;


    @Override
    public List<Notice> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return noticeDao.findAll();
    }

    @Override
    public void add(Notice notice, Long uid) throws Exception {
        //！需要事务控制
        //添加新的公告
        noticeDao.add(notice);
        //添加用户与公告的关联
        noticeDao.addRelation(uid,notice.getNid());
    }

    @Override
    public void delete(Long nid) throws Exception {
        //先删除公告与人员之间的联系
        noticeDao.deleteRelation(nid);
        //再删除公告
        noticeDao.delete(nid);
    }

    @Override
    public Notice findNew() {
        return noticeDao.findNew();
    }
}
