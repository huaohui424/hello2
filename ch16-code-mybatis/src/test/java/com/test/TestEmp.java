package com.test;

import com.entity.Employee;
import com.service.DeptService;
import comfig.AppConfige;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestEmp {

    @Test
    public void test_QueryAll(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfige.class);
        DeptService deptService = context.getBean(DeptService.class);
        List<Employee> employees = deptService.getAll(1, 3);
        for (Employee employee : employees) {
            System.out.println(employee.getUsername());
        }

    }
}
