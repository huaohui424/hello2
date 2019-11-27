package com.comtroller;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import com.service.impl.EmployeeServiceImpl;
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
public class EmployeeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer pageNum = Integer.valueOf(req.getParameter("page"));
        Integer pageSize = Integer.valueOf(req.getParameter("pageSize"));

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeServiceImpl service = context.getBean("employeeService",EmployeeServiceImpl.class);

        List<Employee> employeeList = service.getAll(pageNum,pageSize);
        PageInfo<Employee> pageInfo = new PageInfo<>(employeeList,2);

        req.setAttribute("pageInfo",pageInfo);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    public int getParameterInteger(HttpServletRequest req,String key,Integer defaultValue) {
        Integer returnValue = defaultValue;
        try {
            returnValue = Integer.valueOf(req.getParameter(key));
        } catch (NumberFormatException e) {
        }
        return returnValue;
    }
}
