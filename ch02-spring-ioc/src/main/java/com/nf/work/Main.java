package com.nf.work;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_work.xml");

        SqlSessionFactory sessionFactory =context.getBean("factory2",SqlSessionFactory.class);

        System.out.println(sessionFactory);
    }
}
