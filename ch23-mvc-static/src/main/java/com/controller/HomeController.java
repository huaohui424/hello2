package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(){
        System.out.println("request url: /");
        return "index";
    }

    @RequestMapping("/index")
    public String index2(){
        return "index";
    }

    @RequestMapping("/demo.css")
    public String getCss(){
        System.out.println("request url: /demo.css");
        return "index";
    }


}
