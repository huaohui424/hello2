package com.nf.spring;

import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ApplicationContextUtil {
    public static ApplicationContext getApplicationContext(HttpServletRequest req ){
        ServletContext servletContext = req.getServletContext();
        System.out.println(servletContext);
        ApplicationContext context = (ApplicationContext) servletContext.getAttribute(ApplicationContextInstantiateListener.SPRING_CONTAINER_KEY);

        return context;
    }
}
