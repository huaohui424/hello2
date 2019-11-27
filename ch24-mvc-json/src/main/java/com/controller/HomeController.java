package com.controller;

import com.entity.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class HomeController {
    @RequestMapping("/index")
    public String index(){
        return "view";
    }

    @RequestMapping("/layui")
    public String layui(){
        return "index";
    }

    @RequestMapping("/list")
    @ResponseBody
    public EmpVO list(){
        EmpVO empVO = new EmpVO(100,"abc",new Date());
        return empVO;
    }

    @RequestMapping("/insert")
    @ResponseBody
    public EmpVO insert(@RequestBody EmpVO empVO){
        System.out.println("empVO = " + empVO);
        EmpVO result = new EmpVO(2,"insert",new Date());
        return result;
    }

    @RequestMapping("/insert2")
    @ResponseBody
    public EmpVO insert2(EmpVO empVO){
        EmpVO result = new EmpVO(2,"insert2",new Date());
        return result;
    }


}
