package com.text;

import com.lianxi.entity.Dept;
import com.lianxi.service.DeptService;
import com.nf.entity.Employee;
import com.nf.service.EmployeeService;
import com.nf.service.imlp.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        A a = context.getBean("factory",A.class);
        B b = context.getBean("factory1",B.class);*/
        //System.out.println(b.getClass().getName());

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextxianxi.xml");
        DeptService service = context.getBean("deptService",DeptService.class);
        Dept dept = service.getById();
        System.out.println("employee = " + dept);

    }
}
