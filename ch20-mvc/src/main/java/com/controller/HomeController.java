package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private ApplicationContext context;
    @Autowired
    private EmployeeService service;

    @RequestMapping("/index")
    public String xxx(){
        return "index";
    }

/*    @PostMapping("/insert")
    public ModelAndView insert(String username){
        System.out.println(username);
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        Employee employee = new Employee();
        employee.setUsername(username);
        service.insert(employee);
        return view;
    }*/

    @PostMapping("/insert")
    public ModelAndView insert(@Valid Employee employee,BindingResult bindingResult){
        ModelAndView view = new ModelAndView();
        if(bindingResult.hasErrors()){
            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError error :errors){
                view.addObject(error.getField(),error.getDefaultMessage());
            }
             view.addObject("error",true);
            view.setViewName("index");
        }else {
            view.addObject("error",false);
            view.setViewName("index");
            service.insert(employee);
        }

        return view;
    }


}
