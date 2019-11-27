package com.controller;

import com.entity.Emp;
import com.formatter.EmpFormatter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/formatter")
@ControllerAdvice
public class FormatterController {
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @GetMapping("/date")
    public String receiveDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        System.out.println("date = " + date);
        return "index";
    }

    @GetMapping("/emp")
    public String receiveEmp(@RequestParam("xxx") Emp emp){
        System.out.println("emp = " + emp);
        return "index";
    }

    @InitBinder
    public void xxxx(WebDataBinder dataBinder) {
        dataBinder.addCustomFormatter(new EmpFormatter());
        dataBinder.addCustomFormatter(new DateFormatter());
    }
}
