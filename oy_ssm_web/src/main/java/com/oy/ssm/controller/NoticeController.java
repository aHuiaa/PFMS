package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Notice;
import com.oy.ssm.service.INoticeService;
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
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private INoticeService noticeService;

    //查询所有公告
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                @RequestParam(name = "status" ,defaultValue = "0") Integer status){

        ModelAndView modelAndView = new ModelAndView();

        List<Notice> noticeList = noticeService.findAll(pageNum,pageSize);

        PageInfo pageInfo = new PageInfo(noticeList);

        modelAndView.addObject("pageInfo",pageInfo);

        if (status == 0) {
            modelAndView.setViewName("notice-list");
        }else {
            modelAndView.setViewName("my-notice-list");
        }
        return modelAndView;
    }

    //查询最新公告
    @RequestMapping("/main.do")
    public  ModelAndView findNew(){

        ModelAndView modelAndView = new ModelAndView();

        Notice newNotice = noticeService.findNew();

        modelAndView.addObject("notice",newNotice);
        modelAndView.setViewName("main");

        return modelAndView;
    }

    //添加新的公告
    @RequestMapping("/add.do")
    public String add(Notice notice, @RequestParam("uid") Long uid, RedirectAttributesModelMap redirectAttributes){

        notice.setCreate_time(new Date());

        try {
            noticeService.add(notice,uid);
            redirectAttributes.addFlashAttribute("msgInfo","公告添加成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","公告添加失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //删除公告
    @RequestMapping("/delete.do")
    public String delete(@RequestParam("nid") Long nid, RedirectAttributesModelMap redirectAttributes){

        try {
            noticeService.delete(nid);
            redirectAttributes.addFlashAttribute("msgInfo","公告删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","公告删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

}
