package com.controller.passdatatoview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author cj
 * @date 2019/11/14
 */
@Controller
@RequestMapping("/forward")
public class ForwardPassController {

    @GetMapping("/demo1")
    public String demo(HttpServletRequest request){
        request.setAttribute("f", "/forward/demo1");
        return "view";
    }


    @GetMapping("/demo2")
    public ModelAndView demo2(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("f", "/forward/demo2");
        mav.setViewName("view");
        return mav;
    }


    @GetMapping("/demo3")
    public String demo3(Model model){
        //Model接口的实现类BindingAwareModelMap
        model.addAttribute("f", "/forwad/demo3");
        return "view";
    }


    /**
     * 在控制器方法中,写下面三种类型,效果是一样的
     * 最后一个Map的写法,必须要求键是String类型,
     * @param model
     * @param modelMap
     * @param map
     * @return
     */
    @GetMapping("/demo4")
    public String demo4(Model model, ModelMap modelMap, Map<String,Object> map){
        //Model接口的实现类BindingAwareModelMap
        model.addAttribute("f", "/forwad/demo4");
        return "view";
    }
}
