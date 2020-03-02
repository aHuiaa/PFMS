//package com.oy.ssm.utils;
//
//import com.oy.ssm.domain.AchievementOpinion;
//import com.oy.ssm.domain.UserCultivate;
//import com.oy.ssm.domain.UserFile;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.Version;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
//
//public class WordUtils {
//
//    public static void exportWord(UserFile userFile){
//
//        String cultivate="";
//        String achievement="";
//
//        Map<String,Object> maps = new HashMap<String, Object>();
//        for (UserCultivate userCultivate:userFile.getUserInfo().getUserCultivateList()){
//            cultivate += userCultivate.getCultivate().getCul_name()+"    "+
//                    userCultivate.getCultivate().getStart_timeStr()+"——"+
//                    userCultivate.getCultivate().getEnd_timeStr();
//        }
//        for (AchievementOpinion achievementOpinion:userFile.getUserInfo().getAchievementOpinionList()){
//            achievement += achievementOpinion.getAchievement().getAch_name()+"    "+
//                    achievementOpinion.getO_timeStr();
//
//        }
//        try {
//            maps.put("name", userFile.getUserInfo().getUname());
//            maps.put("gender", userFile.getGender());
//            maps.put("people", userFile.getPeople());
//            maps.put("birthday", userFile.getBirthday());
//            maps.put("id", userFile.getId());
//            maps.put("politics", userFile.getPolitics());
//            maps.put("marital_status", userFile.getMarital_status());
//            maps.put("education", userFile.getEducation());
//            maps.put("school", userFile.getSchool());
//            maps.put("specialty", userFile.getSpecialty());
//            maps.put("Hkadr", userFile.getHk_adr());
//            maps.put("census_register", userFile.getCensus_register());
//            maps.put("HK_type", userFile.getHk_type());
//            maps.put("address", userFile.getAddress());
//            maps.put("postcode", userFile.getPostcode());
//            maps.put("department", userFile.getUserInfo().getDepartmentAndPositionList().get(0).getDepartment().getDepartment_name());
//            maps.put("main_position", userFile.getUserInfo().getDepartmentAndPositionList().get(0).getPosition().getPosition_name());
//            maps.put("start_time", userFile.getUserInfo().getCreate_timeStr());
//            maps.put("end_time", userFile.getUserInfo().getContractList().get(0).getEnd_timeStr());
//            maps.put("source", userFile.getSource());
//            maps.put("cultivate",cultivate);
//            maps.put("achievement", achievement);
//            //Configuration 用于读取ftl文件
//            Configuration configuration = new Configuration(new Version("2.3.22"));
//            configuration.setDefaultEncoding("utf-8");
//
//            /**
//             * 以下是两种指定ftl文件所在目录路径的方式，注意这两种方式都是
//             * 指定ftl文件所在目录的路径，而不是ftl文件的路径
//             */
//            //指定路径的第一种方式（根据某个类的相对路径指定）
////                configuration.setClassForTemplateLoading(this.getClass(), "");
//
//            //指定路径的第二种方式，我的路径是C：/a.ftl
//            configuration.setDirectoryForTemplateLoading(new File("Y:\\upload\\model"));
//
//            //输出文档路径及名称
//            File outFile = new File("Y:\\upload\\ceshiOut.doc");
//
//            //以utf-8的编码读取ftl文件
//            Template template = configuration.getTemplate("test.ftl", "utf-8");
//            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "utf-8"), 10240);
//            template.process(maps, out);
//            out.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
