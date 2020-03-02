package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    //查询所有用户
    @RequestMapping("/findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize){

        ModelAndView modelAndView = new ModelAndView();

        List<UserInfo> userInfoList = userService.findAll(pageNum,pageSize);

        //PageInfo就是一个分页Bean
        PageInfo pageInfo = new PageInfo(userInfoList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    //添加用户
    @RequestMapping("/add.do")
    public String add(UserInfo userInfo, RedirectAttributesModelMap redirectAttributes) throws Exception {

        userInfo.setCreate_time(new Date());

        UserInfo user = userService.findUserInfoByUsername(userInfo.getUsername());

        if (user == null ){

            try {
                //调用service添加
                userService.add(userInfo);
                //如果没有异常抛出，返回true
                redirectAttributes.addFlashAttribute("msgInfo","用户添加成功");
            } catch (Exception e) {
                //如果有异常抛出，返回false
                redirectAttributes.addFlashAttribute("msgInfo","用户添加失败");
                e.printStackTrace();
            }
        }else {
            redirectAttributes.addFlashAttribute("msgInfo","添加失败！用户名已存在！");
        }

        return "redirect:findAll.do";
    }

    //删除用户
    @RequestMapping("/delete.do")
    public String delete(@RequestParam("uids") String uids , RedirectAttributesModelMap redirectAttributes){


        //接受多选框的是字符串，需要将其分割获取uid列表
        String[] uidlist = uids.split(",");

        try {
            userService.delete(uidlist);
            redirectAttributes.addFlashAttribute("msgInfo","用户删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","用户删除失败");
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }

    //根据ID查询用户的详情
    @RequestMapping("/details.do")
    public ModelAndView details(@RequestParam("uid") Long uid,@RequestParam(name = "status",defaultValue = "1") Integer status) throws Exception {

        ModelAndView modelAndView = new ModelAndView();

        UserInfo userInfo = userService.details(uid);

        modelAndView.addObject("userInfo",userInfo);

        if (status==0){
            modelAndView.setViewName("my-user-details");
        }else {
            modelAndView.setViewName("user-details");
        }

        return modelAndView;
    }

    //修改用户信息
    @RequestMapping("/update.do")
    public String update(UserInfo userInfo, RedirectAttributesModelMap redirectAttributes){
        try {
            userService.update(userInfo);
            redirectAttributes.addFlashAttribute("msgInfo","用户信息更新成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","用户信息更新失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //删除用户的角色  根据rid,uid,删除角色与用户的关联
    @RequestMapping("/deleteRole.do")
    public String deleteRole(@RequestParam("rid")Long rid, @RequestParam("uid") Long uid , RedirectAttributesModelMap redirectAttributes){

        try {
            userService.deleteRole(uid,rid);
            redirectAttributes.addFlashAttribute("msgInfo","角色删除成功!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","角色删除失败!");
            e.printStackTrace();
        }
        return "redirect:details.do?uid="+uid;
    }

}
