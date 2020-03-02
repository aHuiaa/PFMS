package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.DepartmentAndPosition;
import com.oy.ssm.service.IDepartmentAndPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/departmentAndPosition")
public class DepartmentAndPositionController {

    @Autowired
    private IDepartmentAndPositionService departmentAndPositionService;

    //查询用户没有的部门-职位
    @RequestMapping("/findOtherDP.do")
    public ModelAndView findOtherDP(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                                    Long uid){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("uid",uid);

        List<DepartmentAndPosition> otherList = departmentAndPositionService.findOther(pageNum, pageSize, uid);

        PageInfo pageInfo = new PageInfo(otherList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("user-dept_posi-add");

        return modelAndView;
    }

    //给用户添加其他部门-职位
    @RequestMapping("/addOtherDP.do")
    public String addOtherDP(@RequestParam("uid") Long uid, @RequestParam("dpids") String dpids, RedirectAttributesModelMap redirectAttributes){

        String[] dpidList = dpids.split(",");

        try {
            departmentAndPositionService.addOtherDP(uid,dpidList,new Date());
            redirectAttributes.addFlashAttribute("msgInfo","部门职位信息添加成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","部门职位信息添加失败");
            e.printStackTrace();
        }
        return "redirect:/user/details.do?uid="+uid;
    }

    //删除用户已有的部门-职位
    @RequestMapping("/deleteDP.do")
    public String deleteDP(@RequestParam("uid") Long uid, @RequestParam("dpid") Long dpid, RedirectAttributesModelMap redirectAttributes){

        try {
            departmentAndPositionService.deleteDP(uid,dpid);
            redirectAttributes.addFlashAttribute("msgInfo","部门职位信息删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","部门职位信息删除失败");
            e.printStackTrace();
        }
        return "redirect:/user/details.do?uid="+uid;
    }


}
