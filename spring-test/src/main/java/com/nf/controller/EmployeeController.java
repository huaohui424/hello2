package com.nf.controller;

import com.nf.entity.Employee;
import com.nf.service.EmployeeService;
import com.nf.spring.ApplicationContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/index")
public class EmployeeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = ApplicationContextUtil.getApplicationContext(req);
        EmployeeService service = context.getBean("employeeService",EmployeeService.class);
        Employee employee = service.getById();
        System.out.println("-----"+employee);
        req.setAttribute("emp",employee);
        req.getRequestDispatcher("index.jsp").forward(req,resp);


        /*ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextUtil.xml");
        EmployeeService service =  context.getBean("employeeService", EmployeeService.class);
        Employee employee = service.getById();

        req.setAttribute("emp", employee);
        req.getRequestDispatcher("index.jsp").forward(req, resp);*/
    }
}
