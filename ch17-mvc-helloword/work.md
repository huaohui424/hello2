
1.不加controller注解出现什么问题？
    找不到地址，相当于没有Controller
2.controller注解换为Component注解是什么情况
    和第一个问题一样
3.RequestMapping注解写为@RequestMapping("") 和@RequestMapping("/")各是什么情况
    两者都是不用输入地址，执行tomcat直接执行代码
4.InternalResourceViewResolver删掉，直接在控制器类的方法里面写死地址，比如return "WEB-INF/jsp/hello.jsp出现什么情况
    正常执行
5.InternalResourceViewResolver去掉前缀与后缀的配置或者只配前缀或只配后缀情况怎么样？？
    只要与Controller中的视图名称整合成一个完整的路径就可以正常执行
6.控制器类的方法名字可以任意吗？
    控制器的方法名字可以任意写
7.控制器类的方法可以是静态的吗？
    可以是静态的
8.控制器类的方法可以返回任意类型吗？比如返回你自己写的一个类
    可以
9.在jsp页面里面遍历输出请求作用域所有的attribute，看看里面有什么？
    
10.ModelAndView类的数据放到哪里了？为什么jsp里写el表达式可以取出来？
    放到了Map集合里面去了
11.既然创建出了一个spring容器，如何获取这个容器呢？
    
12.如果能获取到这个spring容器，容器里面都有多少管理的bean？输出这些bean的名字

13. 如果把DispatcherServlet的url-pattern配置为*.html,那么访问地址为hello.html的时候RequestMapping
注解的值应该写成什么才能访问到这个请求处理方法?
