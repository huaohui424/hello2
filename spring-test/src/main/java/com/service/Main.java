package com.service;

import com.util.Utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext context =new ClassPathXmlApplicationContext("applicationContext_work.xml");
        deptService service = context.getBean("deptService",deptService.class);

        service.delete(Utils.getConnection(),6);

    }
}
