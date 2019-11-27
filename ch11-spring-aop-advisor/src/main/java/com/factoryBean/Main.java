package com.factoryBean;

import com.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_facoryBean.xml");
        EmployeeService service = context.getBean("factoryBean",EmployeeService.class);
        int result = service.add(5,6);
        System.out.println("result = " + result);

    }
}
