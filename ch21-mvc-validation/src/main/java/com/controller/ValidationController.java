package com.controller;

import com.entity.Employee;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ValidationController {

    @RequestMapping("/index")
    public ModelAndView insert(@Valid Employee employee, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        if(bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError error : fieldErrors){
                modelAndView.addObject(error.getField(),error.getDefaultMessage());
                modelAndView.addObject("yic",error.getDefaultMessage());
                System.out.println(error.getField());  //异常字段
                System.out.println(error.getDefaultMessage());  //异常内容

            }
            modelAndView.setViewName("index");
        }else{
            modelAndView.setViewName("insert");
        }

        return modelAndView;
    }
}
