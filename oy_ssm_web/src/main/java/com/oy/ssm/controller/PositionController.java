package com.oy.ssm.controller;

import com.oy.ssm.domain.Position;
import com.oy.ssm.service.IPositionService;
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
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private IPositionService positionService;

    //查询所有职位
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView();

        List<Position> positionList = positionService.findAll();

        modelAndView.addObject("positionList",positionList);

        modelAndView.setViewName("position-list");

        return modelAndView;
    }

    //部门ID查询可添加的职位
    @RequestMapping("/otherPosition")
    public ModelAndView findOtherPositionByDid(@RequestParam("did") Long did){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("did",did);

        List<Position> positionList = positionService.findOtherPositionByDid(did);

        modelAndView.addObject("positionList",positionList);

        modelAndView.setViewName("department-position-add");

        return modelAndView;
    }

    //添加职位
    @RequestMapping("/add.do")
    public String add(Position position, RedirectAttributesModelMap redirectAttributes){

        position.setCreate_time(new Date());

        try {
            positionService.add(position);
            redirectAttributes.addFlashAttribute("msgInfo","职位添加成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","职位添加失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //删除职位
    @RequestMapping("/delete.do")
    public String delete(Long pid, RedirectAttributesModelMap redirectAttributes){

        try {
            positionService.delete(pid);
            redirectAttributes.addFlashAttribute("msgInfo","职位删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","职位删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //更新职位信息
    @RequestMapping("/update.do")
    public String update(Position position, RedirectAttributesModelMap redirectAttributes){

        try {
            positionService.update(position);
            redirectAttributes.addFlashAttribute("msgInfo","职位修改成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","职位修改失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }
}
