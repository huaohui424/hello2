package com;

import com.service.impl.CalcServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CalcServiceImpl service = context.getBean(CalcServiceImpl.class);
        int result = service.add(5,6);
        System.out.println(result);
    }
}
