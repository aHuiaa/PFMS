package com.oy.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.oy.ssm.dao.IUserDao;
import com.oy.ssm.domain.Role;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private HttpServletRequest request;

    @Override
    public List<UserInfo> findAll(Integer pageNum,Integer pageSize) {
        //使用PageHelper进行分页，从pageNum开始，取pageSize条记录
        PageHelper.startPage(pageNum,pageSize);
        return userDao.findAll();
    }

    @Override
    public UserInfo findUserInfoByUsername(String username) throws Exception {
        return userDao.findUserByUsername(username);
    }

    @Override
    public List<UserInfo> findUserInfoByName(String name) {
        return userDao.findUserInfoByName(name);
    }

    @Override
    public void add(UserInfo userInfo) throws Exception {
        userDao.add(userInfo);
    }

    @Override
    public void delete(String[] uidlist) throws Exception {
        //遍历uidlist将选择的id调用dao删除
        for (String uid :uidlist){
            userDao.deleteById(Long.valueOf(uid));
        }
    }

    @Override
    public UserInfo details(Long uid) throws Exception {
        return userDao.findUserByUid(uid);
    }

    @Override
    public void update(UserInfo userInfo) throws Exception {
        userDao.updateInfo(userInfo);
    }

    @Override
    public void deleteRole(Long uid, Long rid) throws Exception {
        userDao.deleteRole(uid,rid);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfo userInfo = null;

        try {
            userInfo = userDao.findUserByUsername(username);
            userInfo.setAchievementOpinionList(null);
            userInfo.setUname(null);
            userInfo.setContractList(null);
            userInfo.setCreate_time(null);
            userInfo.setDepartmentAndPositionList(null);
            userInfo.setOffice(null);
            userInfo.setEmail(null);
            userInfo.setPhone(null);
            request.getSession().setAttribute("login_user",userInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        List<Role> roleList = userInfo.getRoleList();

        List<SimpleGrantedAuthority> authorities = getAuthorities(roleList);

        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPsw(),userInfo.getStatus()==0?false:true,true,true,true,authorities);

        return user;
    }

    private List<SimpleGrantedAuthority> getAuthorities(List<Role> roleList){
        //创建一个SimpleGrantedAuthority类型的集合，SimpleGrantedAuthority是GrantedAuthority的实现类
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //将用户的角色信息构造成SimpleGrantedAuthority对象并放到list中去
        for (Role role:roleList){
            //使用构造器构造一个SimpleGrantedAuthority对象，并放到list集合中
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getPermission()));
        }
        return list;
    }
}
