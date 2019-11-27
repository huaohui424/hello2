package com.param;

import org.aspectj.lang.ProceedingJoinPoint;

public class ParamAdpect {
    public void before(int m,int n ){
        System.out.println("m = " + m);
        System.out.println("n = " + n);
    }

    public Object aroundParam(ProceedingJoinPoint joinPoint){
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Object[] args = joinPoint.getArgs();

        return result;
    }

}
