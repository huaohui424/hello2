package com.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/*
 * 由于不好说这个类属于哪个层面，就用@Component
 * 声明成切面类 @Aspect
 * */
@Component
@Aspect
public class LogAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointcut(){}

    @Before("myPointcut()")
    public void before(){
        System.out.println("前置通知");
    }

    @After("myPointcut()")
    public void after(){
        System.out.println("after----");
    }
}
