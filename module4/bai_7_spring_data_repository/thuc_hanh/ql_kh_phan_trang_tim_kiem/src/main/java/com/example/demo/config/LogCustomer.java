package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LogCustomer {

    private Logger logger = Logger.getLogger(LogCustomer.class.getName());

    @Pointcut("execution(* com.example.demo.service.impl.CustomerServiceImpl.*(..))")
    public void customerService(){}

    public void error(){
        System.out.println("[CMS] ERROR!");
    }

    @AfterThrowing(pointcut = "execution(public * com.example.demo.service.impl.CustomerServiceImpl.*(..))",throwing = "e")
    public void log(Exception e){
        System.out.println("Đã có lỗi xảy ra: " + e.getMessage());
    }

    @Before("customerService()")
    public void log1(JoinPoint joinPoint){
        logger.info("Before: Call " + joinPoint.getSignature().getName());
    }


}
