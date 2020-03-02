package com.oy.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.oy.ssm.domain.Contract;
import com.oy.ssm.service.IContractService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService contractService;

    //查询所有合同
    @RequestMapping("findAll.do")
    public ModelAndView findAll(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize) {

        ModelAndView modelAndView = new ModelAndView();

        List<Contract> contractList = contractService.findAll(pageNum, pageSize);

        PageInfo pageInfo = new PageInfo(contractList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("contract-list");

        return modelAndView;
    }

    //根据uid查询用户的合同
    @RequestMapping("findOne.do")
    public ModelAndView findOne(@RequestParam(name = "pageNum",required = true,defaultValue = "1") Integer pageNum,
                                @RequestParam(name = "pageSize",required = true,defaultValue = "10") Integer pageSize,
                                @RequestParam(name = "uid") Long uid) {

        ModelAndView modelAndView = new ModelAndView();

        List<Contract> contractList = contractService.findOne(pageNum, pageSize,uid);

        PageInfo pageInfo = new PageInfo(contractList);

        modelAndView.addObject("pageInfo",pageInfo);

        modelAndView.setViewName("my-contract-list");

        return modelAndView;
    }

    //上传合同文件
    @RequestMapping("/add.do")
    public String add(Contract contract, MultipartFile contractFile, RedirectAttributesModelMap redirectAttributes){

        //先给redirectAttributes存信息
        redirectAttributes.addFlashAttribute("msgInfo","合同上传失败！");

        //如果前端传入的文件size大于0，说明非空文件/图片，可以进行文件命名的操作，否则在获取文件后缀的时候会包指针越界异常
        if (contractFile != null && contractFile.getSize() > 0){

            //通过UUID随机生成文件的唯一标识
            String fileName = UUID.randomUUID().toString().replaceAll("-","");

            //获取原始文件名
            String oriName = contractFile.getOriginalFilename();

            //通过Substring方法获取子字符串，从“.”为起始索引（包括）开始，即获取文件的扩展名
            String extName = oriName.substring(oriName.lastIndexOf("."));

            try {
                //将文件上传到指定的路径（upload为虚拟路径，可以在tomcat中配置）
                contractFile.transferTo(new File("Y:\\upload\\contract\\"+fileName+"_"+contract.getUserInfo().getUsername()+extName));

                //将文件名保存在数据库中
                contract.setContract(fileName+"_"+contract.getUserInfo().getUsername()+extName);

                //如果上传文件成功则调用service层进行操作
                contractService.add(contract);
                redirectAttributes.addFlashAttribute("msgInfo","合同上传成功！");
            } catch (Exception e) {
                redirectAttributes.addFlashAttribute("msgInfo","合同上传失败！");
                e.printStackTrace();
            }
        }
        return "redirect:findAll.do";
    }
    //下载合同文件
    @RequestMapping("/download.do")
    public ResponseEntity<byte[]> export(String fileName, String filePath) throws IOException {

        HttpHeaders headers = new HttpHeaders();
        File file = new File(filePath+fileName);

        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);

        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }

    //删除合同文件
    @RequestMapping("/delete.do")
    public String delete(Long cid, RedirectAttributesModelMap redirectAttributes){

        try {
            contractService.delete(cid);
            redirectAttributes.addFlashAttribute("msgInfo","合同删除成功！");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("msgInfo","合同删除失败！");
            e.printStackTrace();
        }
        return "redirect:findAll.do";
    }

}
