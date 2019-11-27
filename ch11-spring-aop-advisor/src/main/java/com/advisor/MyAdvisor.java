package com.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * MethodBeforeAdvice:前置通知
 * AfterReturningAdvice:返回通知
 * ThrowsAdvice:异常通知
 * MethodInterceptor:环绕通知
 */
public class MyAdvisor implements MethodBeforeAdvice,AfterReturningAdvice,MethodInterceptor {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before--");
    }

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("after--");
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("around before---");
        Object result = methodInvocation.proceed();
        System.out.println("around after---");
        return result;
    }

    public void afterThrowing(Method method,Object[] args,Object target,RuntimeException re){}
}
