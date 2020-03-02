package com.oy.ssm.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date,String patt){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);

        String format = simpleDateFormat.format(date);

        return format;

    }

    //字符串转换成日期
    public static Date string2Date(String date,String patt) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);

        //将字符串转换为日期格式
        Date parse = simpleDateFormat.parse(date);

        return parse;

    }

    /**
     * 计算2个日期之间相差的  相差多少年月日
     * 比如：2011-02-02 到  2017-03-02 相差 6年，1个月，0天
     * @param fromDate YYYY-MM-DD
     * @param toDate YYYY-MM-DD
     * @return x年x月x日 例如 1年1月1日
     * 日
     */
    public static String dateCompare(String fromDate, String toDate){

        Period period = Period.between(LocalDate.parse(fromDate), LocalDate.parse(toDate));

        StringBuffer sb = new StringBuffer();
        sb.append(period.getYears()).append("年")
                .append(period.getMonths()).append("月")
                .append(period.getDays()).append("日");
        return sb.toString();
    }

//    public static void main(String[] args) throws ParseException {
//        System.out.println(date2String(new Date(),"yyyy-MM-dd HH:mm:ss"));
//
//        System.out.println(string2Date("2019-10-14 20:50:33","yyyy-MM-dd HH:mm:ss"));
//        System.out.println(dateCompare("2019-08-16","2020-08-16"));
//    }
}
