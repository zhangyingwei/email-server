package com.zhangyingwei.email.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;


/**
 * Created by zhangyw on 2017/6/29.
 */
@Aspect
@Configuration
@Scope("prototype")
public class InterCeptorController {

    Logger logger = LoggerFactory.getLogger(InterCeptorController.class);

    @Value("${auth.key}")
    private String authKey;

    @Pointcut("execution(public * com.zhangyingwei.email.controller.*.*(..))")
    public void controllerMethodPointcut(){}

    @Before("controllerMethodPointcut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {}

    @After("controllerMethodPointcut()")
    public void doAfter(JoinPoint joinPoint) throws Throwable {
        // 处理完请求，返回内容
//        logger.info("method:" + joinPoint.getThis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();
        HttpSession session = request.getSession();
        String uri = request.getRequestURI();
        logger.info("date:" + new Date());
        logger.info("ip:" + request.getRemoteAddr());
    }
}
