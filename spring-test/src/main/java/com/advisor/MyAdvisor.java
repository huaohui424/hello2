package com.advisor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.sql.Connection;

public class MyAdvisor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] arguments = methodInvocation.getArguments();
        Connection conn = (Connection) arguments[0];
        conn.setAutoCommit(false);
        try {
            methodInvocation.proceed();//调用连接点方法
        }catch (Exception e){
            conn.rollback();
        }
        conn.commit();
        return null;
    }
}
