package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Cultivate;
import com.oy.ssm.domain.UserCultivate;
import com.oy.ssm.domain.UserInfo;
import com.oy.ssm.service.IUserCultivateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/userCultivate")
public class UserCultivateController {

    @Autowired
    private IUserCultivateService userCultivateService;

    //根据cul_id查询培训的用户列表
    @RequestMapping("/findUsers.do")
    public ModelAndView findUsers(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                   @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize,
                                   Long cul_id){

        ModelAndView modelAndView =new ModelAndView();

        //保存cul_id 培训ID
        modelAndView.addObject("cul_id",cul_id);

        //查询未参与培训的人员
        List<UserInfo> otherUsers = userCultivateService.findOtherUsers(cul_id);

        modelAndView.addObject("otherUsers",otherUsers);

        //查询参与培训的人员
        List<UserInfo> userInfoList = userCultivateService.findUsers(cul_id, pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(userInfoList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("user-cultivate-list");

        return modelAndView;
    }

    //添加 用户-培训关联
    @RequestMapping("/add.do")
    public String add(String userids, @RequestParam("cul_id") Long cul_id, Model model, RedirectAttributes redirectAttributes){

        String[] uidList = userids.split(",");

        try {
            userCultivateService.add(uidList,cul_id);
            redirectAttributes.addFlashAttribute("msgInfo","添加成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","添加失败");
            e.printStackTrace();
        }
        return "redirect:findUsers.do?cul_id="+cul_id;
    }

    //删除用户-培训关联
    @RequestMapping("/delete.do")
    public String delete(String uids,Long cul_id,Model model, RedirectAttributes redirectAttributes){

        String[] uidList = uids.split(",");
        try {
            userCultivateService.delete(uidList,cul_id);
            redirectAttributes.addFlashAttribute("msgInfo","删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","删除失败");
            e.printStackTrace();
        }
        return "redirect:findUsers.do?cul_id="+cul_id;
    }
}
