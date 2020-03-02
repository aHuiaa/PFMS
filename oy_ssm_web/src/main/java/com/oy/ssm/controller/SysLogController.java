package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.SysLog;
import com.oy.ssm.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller()
@RequestMapping("/log")
public class SysLogController {

    @Autowired
    private ISysLogService sysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize){

        //创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        //获取用户信息列表
        List<SysLog> logInfoList = sysLogService.findAll(pageNum,pageSize);

        //用logInfoList构造一个pageInfo对象
        PageInfo pageInfo = new PageInfo(logInfoList);

        //将获取到的用户信息列表存储到Model中
        modelAndView.addObject("pageInfo",pageInfo);

        //设置视图名称
        modelAndView.setViewName("log-list");

        return modelAndView;
    }
}
