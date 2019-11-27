package com.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceAspect {
    @Pointcut("execution(* com.service..*.*(..))")
    public void myPointcut(){}

    @Around("myPointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        Object result = null;

        try {
            Long start = System.currentTimeMillis();
            result = proceedingJoinPoint.proceed();
            Long last = System.currentTimeMillis();
            System.out.println("耗时"+(last-start));
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

}
