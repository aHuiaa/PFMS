package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Role;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    //查询所有角色
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10") Integer pageSize){

        ModelAndView modelAndView = new ModelAndView();

        List<Role> roleList = roleService.findAll(pageNum,pageSize);

        //PageInfo  一个分页Bean
        PageInfo pageInfo = new PageInfo(roleList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("role-list");

        return modelAndView;

    }

    //根据角色rid查询所有用户
    @RequestMapping("/details.do")
    public ModelAndView details(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                @RequestParam(name = "rid")Long rid){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("rid",rid);

        List<UserInfo> userInfoList = roleService.findUserInfoByRid(pageNum, pageSize, rid);

        PageInfo pageInfo = new PageInfo(userInfoList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("role-user-list");

        return modelAndView;
    }

    //根据uid查询可以添加的角色
    @RequestMapping("/findOtherRole.do")
    public ModelAndView findOtherRole(@RequestParam("uid") Long uid ){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("uid",uid);

        List<Role> roleList = roleService.findOrderRoleByUid(uid);

        modelAndView.addObject("roleList",roleList);

        modelAndView.setViewName("user-role-add");

        return modelAndView;
    }

    //给用户添加新的角色 根据uid,rid添加新的角色
    @RequestMapping("/addOrderRole.do")
    public String addOrderRole(@RequestParam("rids")String rids, @RequestParam("uid") Long uid , RedirectAttributesModelMap redirectAttributes){

        String[] ridList = rids.split(",");

        try {
            roleService.addOrderRoleByUidRid(uid,ridList);
            redirectAttributes.addFlashAttribute("msgInfo","角色添加成功!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","角色添加失败!");
            e.printStackTrace();
        }

        return "redirect:/user/details.do?uid="+uid;
    }

    //根据rid,uid,删除角色与用户的关联(角色管理)
    @RequestMapping("/delete.do")
    public String deleteByRidUid(@RequestParam("rid")Long rid, @RequestParam("uids") String uids , RedirectAttributesModelMap redirectAttributes){


        String[] uidList = uids.split(",");

        try {
            roleService.delete(rid,uidList);
            redirectAttributes.addFlashAttribute("msgInfo","角色删除成功!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","角色删除失败!");
            e.printStackTrace();
        }

        return "forward:details.do";
    }

}
