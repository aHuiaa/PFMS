package com.oy.ssm.controller;

import com.oy.ssm.domain.SysLog;
import com.oy.ssm.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

@Component
@Aspect
public class LogAop {

    @Autowired
    HttpServletRequest request; //用于获取IP

    @Autowired
    ISysLogService sysLogService;

    private Date start_time;        //访问的时间
    private Class executionClass;   //访问的类
    private Method executionMethod; //访问的方法

    //在前置通知中，主要获取的是访问时间、访问类和访问的方法
    @Before("execution(* com.oy.ssm.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        //访问的时间
        start_time = new Date();
        //获取访问的类
        executionClass = joinPoint.getTarget().getClass();
        //获取访问的方法的方法签名
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
            executionMethod = executionClass.getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
//        }
    }
//
//    //在前置通知中，主要获取的是访问时间、访问类和访问的方法
//    @Before("execution(* com.oy.ssm.controller.*.*(..))")
//    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
//        //访问的时间
//        start_time = new Date();
//        //获取访问的类
//        executionClass = joinPoint.getTarget().getClass();
//        //获取访问的方法的方法名
//        String methodName = joinPoint.getSignature().getName();
//        Object[] args = joinPoint.getArgs();
//        if (args==null || args.length==0 ){
//            executionMethod = executionClass.getMethod(methodName);
//        }else {
//            //获取有参数的方法，getMethod(String name, Class<?>... parameterTypes)传入的参数是方法名和一个class数组
//            Class[] classArgs= new Class[args.length];
//            for (int i = 0;i<args.length;i++){
//                classArgs[i]=args[i].getClass();
//            }
//            //获取有参数的方法
//            executionMethod = executionClass.getMethod(methodName, classArgs);
//            executionClass.getMethod(methodName);
//        }
//    }

    @After("execution(* com.oy.ssm.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint){
        //访问的url=类上的@RequestMapping注解的value和方法上的@RequestMapping注解的value相加
        String url="";
        //访问的时长
        Long execution_time = new Date().getTime() - start_time.getTime();
       //获取访问的url，url的组成是类的requestMapping和方法的requestMapping
        if (executionClass != SysLogController.class && executionMethod!=null && executionClass != LogAop.class) {
            //获取类上的@RequestMapping注解对象
            RequestMapping classAnnotation = (RequestMapping) executionClass.getAnnotation(RequestMapping.class);
            if (classAnnotation !=null){
                //获取方法上的@RequestMapping注解对象
                RequestMapping methodAnnotation = executionMethod.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null){

                    url=classAnnotation.value()[0]+methodAnnotation.value()[0];

                    //访问的用户的用户名->SecurityContext中可以获取
                    SecurityContext context = SecurityContextHolder.getContext();
                    User user = (User) context.getAuthentication().getPrincipal();
                    String username = user.getUsername();
                    //获取IP->从request中获取
                    String ip = request.getRemoteAddr();
                    //创建SysLog对象并封装数据
                    SysLog sysLog = new SysLog();
                    sysLog.setExecution_time(execution_time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类] "+executionClass.getName()+"    [方法] "+executionMethod.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(username);
                    sysLog.setVisit_time(start_time);
                    //调用service，调用dao将sysLog数据保存到数据库中
                    sysLogService.add(sysLog);
                }
            }
        }
    }
}
