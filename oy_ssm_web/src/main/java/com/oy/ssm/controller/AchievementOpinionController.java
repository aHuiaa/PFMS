package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.AchievementOpinion;
import com.oy.ssm.service.IAchievementOpinionService;
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
@RequestMapping("/opinion")
public class AchievementOpinionController {

    @Autowired
    private IAchievementOpinionService achievementOpinionService;

    //查询所有申请
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize) {
        ModelAndView modelAndView = new ModelAndView();

        List<AchievementOpinion> achievementOpinionList = achievementOpinionService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(achievementOpinionList);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("achievement-opinion-list");

        return modelAndView;
    }

    //根据uid查询用户的荣誉申请记录
    @RequestMapping("/findRec.do")
    public ModelAndView findRec(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                @RequestParam(name = "uid") Long uid) {
        ModelAndView modelAndView = new ModelAndView();

        List<AchievementOpinion> achievementOpinionList = achievementOpinionService.findRec(pageNum, pageSize,uid);

        PageInfo pageInfo = new PageInfo(achievementOpinionList);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("my-achievement-rec");

        return modelAndView;
    }

    //根据uid查询未审批过的部门人员的荣誉申请记录
    @RequestMapping("/findDeptRecN.do")
    public ModelAndView findDeptRec(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                    @RequestParam(name = "uid") Long uid) {
        ModelAndView modelAndView = new ModelAndView();

        List<AchievementOpinion> achievementOpinionList = achievementOpinionService.findDeptRec(pageNum, pageSize,uid);

        PageInfo pageInfo = new PageInfo(achievementOpinionList);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("dept_achievement-N-list");

        return modelAndView;
    }

    //根据uid查询已审批过的部门人员的荣誉申请记录
    @RequestMapping("/findDeptRecY.do")
    public ModelAndView findDeptRecY(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                    @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                    @RequestParam(name = "uid") Long uid) {
        ModelAndView modelAndView = new ModelAndView();

        List<AchievementOpinion> achievementOpinionList = achievementOpinionService.findDeptRecY(pageNum, pageSize,uid);

        PageInfo pageInfo = new PageInfo(achievementOpinionList);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("my-achievement-rec");

        return modelAndView;
    }

    //根据uid查询用户已经获得的荣誉
    @RequestMapping("/findPass.do")
    public ModelAndView findPass(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                @RequestParam(name = "uid") Long uid) {
        ModelAndView modelAndView = new ModelAndView();

        List<AchievementOpinion> achievementOpinionList = achievementOpinionService.findPass(pageNum, pageSize,uid);

        PageInfo pageInfo = new PageInfo(achievementOpinionList);

        modelAndView.addObject("pageInfo", pageInfo);

        modelAndView.setViewName("my-achievement");

        return modelAndView;
    }

    //删除申请
    @RequestMapping("/delete.do")
    public String delete(Long oid, RedirectAttributesModelMap redirectAttributes) {

        try {
            achievementOpinionService.delete(oid);
            redirectAttributes.addFlashAttribute("msgInfo","删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //增加申请
    @RequestMapping("/add.do")
    public String add(AchievementOpinion achievementOpinion, @RequestParam(name = "status",defaultValue = "0",required = true) Integer status,RedirectAttributesModelMap redirectAttributes) {

        //设置申请的时间
        achievementOpinion.setA_time(new Date());

        try {
            achievementOpinionService.add(achievementOpinion);
            redirectAttributes.addFlashAttribute("msgInfo","申请成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","申请失败！");
            e.printStackTrace();
        }
        if (status == 0){
            return "redirect:findAll.do";
        } else {
            return "redirect:/achievement/findAll.do?status=1";
        }
    }

    //修改审批意见
    @RequestMapping("/update.do")
    public String update(AchievementOpinion achievementOpinion, RedirectAttributesModelMap redirectAttributes) {

        if (achievementOpinion.getOpinion().equals("通过")){
        achievementOpinion.setO_time(new Date());
        }

        try {
            achievementOpinionService.update(achievementOpinion);
            redirectAttributes.addFlashAttribute("msgInfo","修改成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","修改失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
