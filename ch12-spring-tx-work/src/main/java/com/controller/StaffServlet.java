package com.controller;

import com.entity.Staff;
import com.github.pagehelper.PageInfo;
import com.service.StaffInsertAndDeleteManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/index")
public class StaffServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        StaffInsertAndDeleteManager manager = context.getBean("manager",StaffInsertAndDeleteManager.class);

       // int pageNum = Integer.valueOf(req.getParameter("pageNum"));
        //int pageSize = Integer.valueOf(req.getParameter("pageSize"));
        List<Staff> staffList = manager.getAll(1, 2);
        PageInfo<Staff> pageInfo = new PageInfo<>(staffList,2);

        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }
}
