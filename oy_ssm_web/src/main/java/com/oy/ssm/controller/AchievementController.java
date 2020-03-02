package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Achievement;
import com.oy.ssm.service.IAchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
@RequestMapping("/achievement")
public class AchievementController {

    @Autowired
    private IAchievementService achievementService;

    //查询所有奖项
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                @RequestParam(name = "status",defaultValue = "0") Integer status) {
        ModelAndView modelAndView = new ModelAndView();

        List<Achievement> achievementList = achievementService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(achievementList);

        modelAndView.addObject("pageInfo", pageInfo);

        if (status==0){
            modelAndView.setViewName("achievement-list");
        } else {
            modelAndView.setViewName("my-achievement-apply");
        }

        return modelAndView;
    }

    //增加奖项
    @RequestMapping("/add.do")
    public String add(Achievement achievement, RedirectAttributesModelMap redirectAttributes) {
        try {
            achievementService.add(achievement);
            redirectAttributes.addFlashAttribute("msgInfo","奖项添加成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","奖项添加失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //修改奖项信息
    @RequestMapping("/update.do")
    public String update(Achievement achievement,RedirectAttributesModelMap redirectAttributes) {
        try {
            achievementService.update(achievement);
            redirectAttributes.addFlashAttribute("msgInfo","奖项修改成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","奖项修改失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //删除奖项信息
    @RequestMapping("/delete.do")
    public String delete(Long ach_id,RedirectAttributesModelMap redirectAttributes) {
        try {
            achievementService.delete(ach_id);
            redirectAttributes.addFlashAttribute("msgInfo","奖项删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","奖项删除失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
