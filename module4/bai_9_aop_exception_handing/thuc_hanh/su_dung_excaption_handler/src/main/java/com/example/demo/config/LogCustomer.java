package com.example.demo.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.logging.Logger;

@Aspect
@Component
public class LogCustomer {

//    private Logger logger = Logger.getLogger(LogCustomer.class.getName());

    @Pointcut("execution(* com.example.demo.service.impl.CustomerServiceImpl.*(..))")
    public void customerService(){}

    @AfterThrowing(pointcut = "execution(public * com.example.demo.service..*.*(..))",throwing = "e")
    public void log(JoinPoint joinPoint,Exception e){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        System.err.println("Đã có lỗi xảy ra: "+ className+"."+method+"."+args+": " + e.getMessage());
    }

//    @Before("customerService()")
//    public void log1(JoinPoint joinPoint){
//        logger.info("Before: Call " + joinPoint.getSignature().getName());
//    }


}
