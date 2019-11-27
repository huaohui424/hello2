package com;

import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotaionText {
    @Test
    public void testAnnoHelloWorld(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean(EmployeeService.class);
        System.out.println(service);
    }

    @Test
        public void testAnno_ioc(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeService service = context.getBean(EmployeeService.class);
        service.update();

    }

    @Test
    public void testAnno_ioc_collection(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceImpl service = context.getBean(EmployeeServiceImpl.class);
        service.displayAutowireCollectionInject();

    }

}
