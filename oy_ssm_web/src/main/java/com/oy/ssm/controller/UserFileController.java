package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.AchievementOpinion;
import com.oy.ssm.domain.UserCultivate;
import com.oy.ssm.domain.UserFile;
import com.oy.ssm.service.IUserFileService;
import com.oy.ssm.utils.DateUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//档案
@Controller
@RequestMapping("/file")
public class UserFileController {

    @Autowired
    private IUserFileService userFileService;

    //查询所有用户的档案
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum", required = true, defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize", required = true, defaultValue = "10")  Integer pageSize){

        ModelAndView modelAndView = new ModelAndView();

        List<UserFile> userFileList = userFileService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(userFileList);

        modelAndView.addObject(pageInfo);

        modelAndView.setViewName("file-list");

        return modelAndView;
    }

    //查询单个档案信息->通过fid
    @RequestMapping("/findOne.do")
    public ModelAndView findOne(@RequestParam(name = "fid")Long fid, @RequestParam(name = "status",defaultValue = "1") Integer status){
        ModelAndView modelAndView = new ModelAndView();

        UserFile userFile = userFileService.findOne(fid);

        modelAndView.addObject("userFile",userFile);

        modelAndView.setViewName("file-details");

        if (status==0) {
            modelAndView.setViewName("my-file-details");
        }else {
            modelAndView.setViewName("file-details");
        }
        return modelAndView;
    }

//    //查询单个档案信息->通过uid
//    @RequestMapping("/details.do")
//    public ModelAndView details(@RequestParam(name = "uid") Long uid,@RequestParam(name = "status",defaultValue = "1") Integer status){
//        ModelAndView modelAndView = new ModelAndView();
//
//        UserFile userFile = userFileService.details(uid);
//
//        modelAndView.addObject("userFile",userFile);
//
//        if (status==0) {
//            modelAndView.setViewName("my-file-details");
//        }else {
//            modelAndView.setViewName("file-details");
//        }
//        return modelAndView;
//    }

    //删除档案
    @RequestMapping("/delete.do")
    public String delete(@RequestParam("fid") Long fid , RedirectAttributesModelMap redirectAttributes){

        try {
            userFileService.delete(fid);
            redirectAttributes.addFlashAttribute("msgInfo","档案删除成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","档案删除失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //新增档案
    @RequestMapping("/add.do")
    public String add(UserFile userFile , RedirectAttributesModelMap redirectAttributes){

        try {
            userFileService.add(userFile);
            redirectAttributes.addFlashAttribute("msgInfo","档案添加成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","档案添加失败");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

    //修改档案
    @RequestMapping("/update.do")
    public String update(UserFile userFile , RedirectAttributesModelMap redirectAttributes){

        try {
            userFileService.update(userFile);
            redirectAttributes.addFlashAttribute("msgInfo","档案修改成功");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","档案修改失败");
            e.printStackTrace();
        }
        return "redirect:findOne.do?fid="+userFile.getFid();
    }

    //下载档案
    @RequestMapping("/download.do")
    public ResponseEntity<byte[]> download(Long fid) throws IOException {

        UserFile userFile = userFileService.findOne(fid);

        //档案命名
        String filename = userFile.getUserInfo().getUname()+ DateUtils.date2String(new Date(),"yyyy年MM月dd日")+".doc";

        String cultivate="";
        String achievement="";

        Map<String,Object> maps = new HashMap<String, Object>();
        for (UserCultivate userCultivate:userFile.getUserInfo().getUserCultivateList()){
            cultivate += userCultivate.getCultivate().getCul_name()+"    "+
                    userCultivate.getCultivate().getStart_timeStr()+"——"+
                    userCultivate.getCultivate().getEnd_timeStr()+(char)11;
        }
        for (AchievementOpinion achievementOpinion:userFile.getUserInfo().getAchievementOpinionList()){
            achievement += achievementOpinion.getAchievement().getAch_name()+"    "+
                    achievementOpinion.getO_timeStr()+(char)11;
        }
        //生成档案
        try {
            maps.put("name", userFile.getUserInfo().getUname());
            maps.put("gender", userFile.getGender());
            maps.put("people", userFile.getPeople());
            maps.put("birthday", userFile.getBirthdayStr());
            maps.put("id", userFile.getId());
            maps.put("politics", userFile.getPolitics());
            maps.put("marital_status", userFile.getMarital_status());
            maps.put("education", userFile.getEducation());
            maps.put("school", userFile.getSchool());
            maps.put("specialty", userFile.getSpecialty());
            maps.put("Hkadr", userFile.getHk_adr());
            maps.put("census_register", userFile.getCensus_register());
            maps.put("HK_type", userFile.getHk_type());
            maps.put("address", userFile.getAddress());
            maps.put("postcode", userFile.getPostcode());
            maps.put("department", userFile.getUserInfo().getDepartmentAndPositionList().get(0).getDepartment().getDepartment_name());
            maps.put("main_position", userFile.getUserInfo().getDepartmentAndPositionList().get(0).getPosition().getPosition_name());
            maps.put("start_time", userFile.getUserInfo().getCreate_timeStr());
            maps.put("end_time", userFile.getUserInfo().getContractList().get(0).getEnd_timeStr());
            maps.put("source", userFile.getSource());
            maps.put("cultivate",cultivate);
            maps.put("achievement", achievement);
            //Configuration 用于读取ftl文件
            Configuration configuration = new Configuration(new Version("2.3.22"));
            configuration.setDefaultEncoding("utf-8");

            /**
             * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是
             * 指定ftl文件所在目录的路径，而不是ftl文件的路径
             */
            //指定路径的第一种方式（根据某个类的相对路径指定）
//                configuration.setClassForTemplateLoading(this.getClass(), "");

            //指定路径的第二种方式，我的路径是C：/a.ftl
            configuration.setDirectoryForTemplateLoading(new File("Y:\\upload\\model"));

            //输出文档路径及名称
            File outFile = new File("Y:\\upload\\"+filename);

            //以utf-8的编码读取ftl文件
            Template template = configuration.getTemplate("test.ftl", "utf-8");
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
            template.process(maps, out);
            out.close();

            //下载档案
            HttpHeaders headers = new HttpHeaders();

            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            headers.setContentDispositionFormData("attachment", filename);

            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(outFile),
                    headers, HttpStatus.CREATED);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
