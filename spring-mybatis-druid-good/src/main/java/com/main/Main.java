package com.main;

import com.entity.Employee;
import com.service.impl.EmployeeServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        EmployeeServiceImpl service = context.getBean("employeeService", EmployeeServiceImpl.class);
        List<Employee> employees = service.getAll(2,3);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
