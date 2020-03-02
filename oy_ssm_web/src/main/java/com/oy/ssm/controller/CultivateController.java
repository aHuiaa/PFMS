package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Cultivate;
import com.oy.ssm.service.ICultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.util.List;

@Controller
@RequestMapping("/cultivate")
public class CultivateController {

    @Autowired
    private ICultivateService cultivateService;

    //查询培训的列表
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize){

        ModelAndView modelAndView = new ModelAndView();

        List<Cultivate> cultivateList = cultivateService.findAll(pageNum, pageSize);

        PageInfo pageInfo=new PageInfo(cultivateList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("cultivate-list");

        return modelAndView;
    }

    //查询培训的列表
    @RequestMapping("/userCul.do")
    public ModelAndView userCul(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                                @RequestParam(name="uid") Long uid){

        ModelAndView modelAndView = new ModelAndView();

        List<Cultivate> cultivateList = cultivateService.userCul(pageNum, pageSize,uid);

        PageInfo pageInfo=new PageInfo(cultivateList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("my-cultivate-list");

        return modelAndView;
    }

    //增加一场培训
    @RequestMapping("/add.do")
    public String add(Cultivate cultivate, RedirectAttributesModelMap redirectAttributes){

        try {
            cultivateService.add(cultivate);
            redirectAttributes.addFlashAttribute("msgInfo","添加成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","添加失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //删除一场培训
    @RequestMapping("delete")
    public String delete(Long cul_id, RedirectAttributesModelMap redirectAttributes){

        try {
            cultivateService.delete(cul_id);
            redirectAttributes.addFlashAttribute("msgInfo","删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //修改一场培训信息
    @RequestMapping("/update.do")
    public String update(Cultivate cultivate, RedirectAttributesModelMap redirectAttributes){

        try {
            cultivateService.update(cultivate);
            redirectAttributes.addFlashAttribute("msgInfo","修改成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","修改失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
