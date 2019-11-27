# servlet的url-pattern理解
当在web.xml中配置多个servlet时,tomcat对其的映射匹配是有优先级的,考虑到在mvc中DispatcherServlet
的url-pattern常设置为/,所以只说明2种url-pattern,一种是/,另一种是扩展名模式,其它模式的详细情况见我
写的servlet的md文件
 记住:扩展名映射的优先级高于/
 
 而且在servlet的url-pattern配置中/ 代表着找不到对应servlet处理当前请求的url时,由这个/对应的servlet处理
 简单来说就是/的url-pattern就可以处理所有的请求,比如/first,/demo.css,/a/b/c.js等都可以处理
 
 而在tomcat和jetty这种servlet容器中,这个url-pattern为/,其对应的servlet是tomcat自己编写,并配置
 在全局的web.xml中的(在tomcat安装目录下的web.xml中)
 
 所以:当DispatcherServlet的url-pattern设置为/,就表示任何请求都交给DispatcherServlet去处理
 
# 为什么不能访问静态资源
假定在web根目录下有一个demo.css,在mvc环境下为什么不能访问/demo.css,原因是:
1. 项目的web.xml中只配置了一个DispatcherServlet,它的url-pattern为/
2. 所以/demo.css就交给DispatcherServlet去处理
3. DispatcherServlet把/demo.css交给所有的HandlerMapping接口的实现
4. 遍历所有的HandlerMapping,看哪一个HandlerMapping可以依据/demo.css找到对应的Hander
5. 由于默认情况下,RequestMappingHandlerMapping只会找哪一个方法上修饰了@RequestMapping("/demo.css")
6. 结果找不到,所以RequestMappingHandlerMapping就找不到Handler处理这个请求.
7. 找不到对应的Handler,就没法由HandlerAdapter去处理这个请求.
8. mvc就报404错误
但是:
1. 当在applicationcontext.xml中配置了mvc:resource就意味添加一个HandlerMapping
并告诉此handlerMapping,哪些地址可以处理,交给谁处理
2.所以静态资源的处理就完成了.

# 方式一:
```xml
<mvc:resources mapping="/css/**" location="/static/css/"/>
```
当请求地址为/css/demo.css 时到web根目录下的/static/css/demo.css找文件
当请求地址为/css/main/demo2.css 时到web根目录下的/static/css/main/demo2.css找文件

当有多个位置(location)要设置时,用逗号分隔.mvc内部用ResourceHttpRequestHandler来处理

你也可以把资源放置在类路径下,比如下面的配置
```xml
 <mvc:resources mapping="/css/**" location="classpath:/static/css/"/>
```
上面的location配置不支持classpath*这种配置方式.
> 注意:这种方式需要启用mvc:annotation-driven,因为它会把对静态资源的处理的HandlerMapping
> 注册在最后(优先级最低),不开启就导致RequestMapping可能失效
## 源码分析
1. 配置mvc:resources时会利用ResourcesBeanDefinitionParser解析
2. 解析器会注册ResourceHttpRequestHandler,此类HttpRequestHandler的实现类,并把location的值传给ResourceHttpRequestHandler
3. 解析器也会注册SimpleUrlHandlerMapping,并设置mapping属性设置的值作为此HandlerMapping的url值
4. 当请求过来时会依据url交给HandlerMapping处理,然后就会调用ResourceHttpRequestHandler来处理资源请求
# 方式二
把资源的处理转交给默认servlet去处理,但仍然利用了spring mvc框架
一般所有的servlet容器都有默认的处理静态资源的servlet,如果想让spring mvc让默认servlet处理静态资源
只需要在DispatcherServlet关联的spring元数据中配置下面的内容即可

```xml
<mvc:default-servlet-handler />
```
如果容器的默认servlet的名字不叫default,那么就设定default-servlet-name属性的值为对应容器的
servlet名字即可.
```xml
<mvc:default-servlet-handler default-servlet-name="xxx"/>
```
mvc内部用DefaultServletHttpRequestHandler来处理默认servlet服务静态资源的情况
> 注意:这种方式需要启用mvc:annotation-driven,因为它会把对静态资源的处理的HandlerMapping
> 注册在最后(优先级最低),不开启就导致RequestMapping可能失效
> 而且这种方式要求资源放置在默认servlet可以访问的地方,比如web根目录下就可以,类路径下就不行
## 源码分析
    1. 当在xml中设置了mvc:default-servlet-handler之后,会由DefaultServletHandlerBeanDefinitionParser解析
    此解析器的源代码非常少,是学习BeanDefinitionParser的一个好的入口点
    2. 解析器会注册SimpleUrlHandlerMapping 针对的地址为/**,还会注册对应的HttpRequestHandlerAdapter
    3.此HandlerAdapter就是专门处理HttpRequestHandler的执行的,而DefaultServletHttpRequestHandler就是
    HttpRequestHandler的实现类
    
 >  由于它注册的HandlerMapping的地址为/**,所以可以处理任何请求,所以需要把此HandlerMapping放在最后以避免它先处理了
 >  其它的请求,比如RequestMappingHandlerMapping能处理的请求.这点可以通过设置其order来实现 

# 方式三
直接使用容器的默认servlet处理,不经过spring mvc框架
比如下面的配置
```xml
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.css</url-pattern>
</servlet-mapping>
<servlet-mapping>
    <servlet-name>default</servlet-name>
    <url-pattern>*.js</url-pattern>
</servlet-mapping>
```

# 总结
1. 方式1与方式二都要求配置mvc:annotation-driven 
2. 方式1用到了spring mvc的特性,支持资源解析器链与资源转换.
3. 方式二与方式三,静态资源放置的位置必须是默认servlet可以访问的地方 

**** 建议开发时用mvc:resources的方式 ****  
# 参考资料
https://blog.coding.net/blog/spring-static-resource-process
https://www.baeldung.com/spring-mvc-static-resources
https://blog.csdn.net/yanguo110/article/details/78169888(spring mvc静态资源的三种处理方法)