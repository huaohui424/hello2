package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GetDataTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DbConfig dbConfig = context.getBean(DbConfig.class);

        System.out.println(dbConfig.getData());
    }
}
