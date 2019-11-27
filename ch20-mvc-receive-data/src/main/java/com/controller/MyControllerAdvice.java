package com.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class MyControllerAdvice {
    @InitBinder
    public void xxx(WebDataBinder dataBinder){
        dataBinder.addCustomFormatter(new DateFormatter());
    }
}
