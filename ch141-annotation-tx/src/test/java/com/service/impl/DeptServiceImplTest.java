package com.service.impl;

import config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class DeptServiceImplTest {

    @Test
    public void txDemo() {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
       DeptServiceImpl service = context.getBean(DeptServiceImpl.class);
       service.txDemo();
    }
}