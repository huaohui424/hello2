package com.controller;

import org.omg.PortableInterceptor.Interceptor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        System.out.println("index controller");
        return "index";
    }

    @RequestMapping("/index2")
    public String index2(){
        System.out.println("index controller222");
        return "index";
    }

    @RequestMapping("/login")
    public String show(String username, String password){
        System.out.println("用户名"+username);
        System.out.println("密码"+password);
        if(username.equals("admin")&&password.equals("123")){
            return "index";
        }
         return "admin";
    }

}
