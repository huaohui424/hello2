package controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class HelloController {

    @RequestMapping("/index0")
    private String GET(){
        System.out.println("helloword");
        return "WEB-INF/jsp/hello";
    }

    @RequestMapping("/a")
    private String ant(){
        System.out.println("ant");
        return "hello.jsp";
    }

    @RequestMapping("index")
    public ModelAndView hello(){
        ModelAndView view = new ModelAndView();

        view.setViewName("hello.jsp");    //给逻辑视图一个名称
        view.addObject("mvp","huaohui");

        return view;
    }

    @RequestMapping("*")
    public ModelAndView hello2(){
        ModelAndView view = new ModelAndView();

        view.setViewName("hello.jsp");    //给逻辑视图一个名称
        view.addObject("mvp","备用的地址");

        return view;
    }

    @RequestMapping(value = {"one","two"})
    public ModelAndView hello4(){
        ModelAndView view = new ModelAndView();

        view.setViewName("hello.jsp");    //给逻辑视图一个名称
        view.addObject("mvp","这是多个地址！");

        return view;
    }


}
