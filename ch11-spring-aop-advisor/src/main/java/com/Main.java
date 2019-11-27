package com;

import com.service.EmployeeService;
import com.service.ipml.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean("service",EmployeeService.class);

        int result = service.add(5,6);
        System.out.println(result);
    }
}
