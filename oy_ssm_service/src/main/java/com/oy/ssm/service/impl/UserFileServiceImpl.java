package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IUserFileDao;
import com.oy.ssm.domain.UserFile;
import com.oy.ssm.service.IUserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFileServiceImpl implements IUserFileService {

    @Autowired
    private IUserFileDao userFileDao;

    @Override
    public List<UserFile> findAll(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return userFileDao.findAll();
    }

    @Override
    public UserFile findOne(Long fid) {
        return userFileDao.findOne(fid);
    }

    @Override
    public void add(UserFile userFile) throws Exception {
        userFileDao.add(userFile);
    }

    @Override
    public void delete(Long fid) throws Exception {
        userFileDao.delete(fid);
    }

    @Override
    public void update(UserFile userFile) throws Exception {
        userFileDao.update(userFile);
    }

    @Override
    public UserFile details(Long uid) {
        return userFileDao.findOneByUid(uid);
    }
}
