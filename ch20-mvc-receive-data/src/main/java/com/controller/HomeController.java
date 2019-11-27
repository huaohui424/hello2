package com.controller;

import com.entity.Emp;
import com.entity.EmpVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/wrapper")
    public String index(String abc, Integer pageNo){
        //直接获取了视图里所输入的值
        System.out.println("abc = " + abc);
        System.out.println("pageNo = " + pageNo);
        return "index";
    }

    @GetMapping("/simple")
    public String index(int pageNo){
        //简单类型，不给它赋值的时候就会报错
        System.out.println("pageNo = " + pageNo);
        return "index";
    }

    @GetMapping("/simple2")
    public String index2(@RequestParam(value = "page",required = false,defaultValue = "1") int pageNo){
        //命名新的名字page，required=false ： 可以不用输入值    default默认=1
        System.out.println("pageNo = " + pageNo);
        return "index";
    }

    @GetMapping("aaa/bbb/{pageNo}")
    public String index3(@PathVariable("PageNo") int pageNo){
        System.out.println("pageNo = " + pageNo);
        return "index";
    }

    @GetMapping("/complex")
    public String index(Emp emp){
        System.out.println("emp = " + emp);
        return "index";
    }

    @GetMapping("/list")
    public String index(EmpVO empVO){
        //赋值：emps.username
        System.out.println("empVO = " + empVO);
        return "index";
    }

    @GetMapping("/array")
    public String index(String[] name){

        System.out.println("name = " + name);
        return "index";
    }

}
