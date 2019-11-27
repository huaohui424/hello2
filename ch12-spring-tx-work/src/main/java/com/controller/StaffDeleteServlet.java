package com.controller;

import com.entity.Staff;
import com.service.StaffInsertAndDeleteManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class StaffDeleteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffInsertAndDeleteManager manager = context.getBean("manager",StaffInsertAndDeleteManager.class);
        int id = Integer.valueOf(req.getParameter("id"));
        manager.deleteById(id);
        resp.sendRedirect("index");
    }
}
