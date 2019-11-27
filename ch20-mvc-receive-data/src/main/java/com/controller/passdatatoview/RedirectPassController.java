package com.controller.passdatatoview;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author cj
 * @date 2019/11/14
 */
@Controller
@RequestMapping("/redirect")
public class RedirectPassController {
    // 第一组方法:利用session(HttpSession)和application(ServletContext)
    @GetMapping("/demo1")
    public String demo1(HttpSession session){
        session.setAttribute("f", "/redirect/demo1");
        return "redirect:demo12";
    }

    @GetMapping("/demo12")
    public String demo12(){

        return "view";
    }

// 利用拼接url的方式传递数据,url致命缺点:1.长度是有限制,2.拼接字符繁琐
    @GetMapping("/demo21")
    public String demo21(){

        return "redirect:demo22?f=redirect-demo21";
    }

    @GetMapping("/demo22")
    public String demo22(String f, Model model){
        model.addAttribute("f",f);

        return "view";
    }

    @GetMapping("/demo31")
    public String demo31(RedirectAttributes redirectAttributes){
        //因为我们是重定向到32,所以addAttribute添加的数据自动帮我们拼接到url上
        redirectAttributes.addAttribute("f1", "demo31 f1");
        // addFlashAttribute是把数据自动放到session中,跳转到的方法demo32的model参数自动有这个值.
        redirectAttributes.addFlashAttribute("f", "demo3-flash");//把数据放到session中
        return "redirect:demo32";
    }

    @GetMapping("/demo32")
    public String demo32(String f1, Model model){
        return "view";
    }

    //因为addFlashAttribute是把数据放到session中,读取到了之后自动从session中删除数据
    //这个方法用来演示已经读不到数据,操作步骤:/demo31->跳转到了32,接着访问/demo33
    @GetMapping("/demo33")
    public String demo33(){
        return "view";
    }
}
