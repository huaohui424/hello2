package com.service;

import com.entity.Staff;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffInsertAndDeleteManager manager = context.getBean("manager",StaffInsertAndDeleteManager.class);
        List<Staff> staffList = manager.getAll(1, 2);
        for (Staff staff : staffList) {
            System.out.println(staff.getName());
        }

//        Staff staff = new Staff("aa");
//        manager.insert(staff);


        //manager.deleteById(5);

    }

}
