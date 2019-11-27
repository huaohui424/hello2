package com.service;

import com.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DeptDaoServiceTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        DeptDaoServiceImpl service = context.getBean(DeptDaoServiceImpl.class);
        service.txTest();

    }
}
