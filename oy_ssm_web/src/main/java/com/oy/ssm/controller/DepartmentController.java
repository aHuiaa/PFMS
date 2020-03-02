package com.oy.ssm.controller;

import com.oy.ssm.domain.Department;
import com.oy.ssm.service.IDepartmentService;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    //查询部门列表
    @RequestMapping("findAll.do")
    public ModelAndView findAll(){

        ModelAndView modelAndView = new ModelAndView();

        List<Department> departmentList = departmentService.findAll();

        modelAndView.addObject("departmentList",departmentList);

        modelAndView.setViewName("department-list");

        return modelAndView;
    }

    //添加部门
    @RequestMapping("/add.do")
    public String add(Department department, RedirectAttributesModelMap redirectAttributes){

        //设置创建时间
        department.setCreate_time(new Date());

        try {
            //调用Service
            departmentService.add(department);
            //反馈操作信息 成功添加
            redirectAttributes.addFlashAttribute("msgInfo","部门添加成功！");
        } catch (Exception e) {
            //反馈操作信息 添加失败
            redirectAttributes.addFlashAttribute("msgInfo","部门添加失败！");
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }

    //删除部门
    @RequestMapping("/delete.do")
    public String delete(@RequestParam("did") Long did, RedirectAttributesModelMap redirectAttributes){

        try {
            departmentService.delete(did);
            //反馈操作信息 成功添加
            redirectAttributes.addFlashAttribute("msgInfo","部门删除成功！");
        } catch (Exception e) {
            //反馈操作信息 添加失败
            redirectAttributes.addFlashAttribute("msgInfo","部门删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //给部门添加新的职位
    @RequestMapping("/addOtherPosition.do")
    public String addOtherPosition(@RequestParam("did") Long did,@RequestParam("pids") String pids,RedirectAttributesModelMap redirectAttributes){

        String[] pidList = pids.split(",");

        try {
            departmentService.addOtherPosition(did,pidList,new Date());
            redirectAttributes.addFlashAttribute("msgInfo","职位关联成功！");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("msgInfo","职位关联失败！");
        }
        return "redirect:findAll.do";
    }

    //给部门删除已有的职位
    @RequestMapping("/deletePosition.do")
    public String deletePosition(@RequestParam("did") Long did,@RequestParam("pid") Long pid,RedirectAttributesModelMap redirectAttributes) {
        try {
            departmentService.deletePosition(did,pid);
            redirectAttributes.addFlashAttribute("msgInfo","职位删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","职位删除失败！");
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }

    //修改部门信息
    @RequestMapping("/update.do")
    public String update(Department department,RedirectAttributesModelMap redirectAttributes) {
        try {
            departmentService.update(department);
            redirectAttributes.addFlashAttribute("msgInfo","部门修改成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","部门修改失败！");
            e.printStackTrace();
        }

        return "redirect:findAll.do";
    }

}
