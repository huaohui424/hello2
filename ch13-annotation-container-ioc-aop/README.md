# 容器
1.xml:compent-scan
2 Controller,Service,Repository,Componet
3.PostConstruct,PreDestroy
4.Scope

# IOC
Autowire
    注意List与Map的注入.
Resourcex
Inject

    多个候选的解决办法
    @Primary
    @Qulifier
# AOP
1.aspectj-autoproxy.相当于让spring理解aop相关的注解
    proxy-target-class属性的作用
2. Aspect 切面

3.通知:
    @Before
    @After
    @AfterReturning
    @AfterThrowing
    @Around
4 切点表达式
    方法是无参无返回值
  # 读取外部属性文件
  利用PropertySource注解读取外部文件到Environment
  
  使用外部文件的数据,方法有2种
  1.利用Environment.getProperty
  2.利用Value注解
    
    @Pointcut
    
 1.作业:Autowired与Resource的区别,
 @Resource是Java自己的注解，有type和name属性，spring将这个name解析为bean
 的名字，而type解析为bean的类型。
 @Autowired是spring的注解，Autowired只根据type进行注入，不会去匹配name,
 当无法辨别注入对象时，需要依赖@Qualifier或@Primary注解一起来修饰。
 
 2.添加4个注解时,默认bean的名字是什么?如何改变
    @Repository 用来定义持久层(domain)的组件
    @Service    用来定义业务层(service)的组件
    @Componet   用来定义不在上述范围内的一般性组件
    @Controller 用来定义控制(dao)层的组件 
    指定value就可以自己定义名称
    当类型名称的第一个字母为大写，且第二个字母为小写，默认bean的名字为第一个字母变
    小写，其他的不变  像Book--->book
    当类型名称的第一个字母为大写，且第二个字母也是大写，默认bean的名称与原来名称
    一样，如EMployee-->EMployee
    
 3.做好笔记
 
 4 @Value注解除了修饰在字段上,还可以修饰在哪里?
 FIELD（字段），METHOD（方法），PARAMETER（参数），ANNOTATION_TYPE（注解）
    参数，方法，字段，
 5.Autowired注解的required属性是什么意思?
    required:默认是true,表示必须给引用类型赋值成功,如果赋值失败,程序报错，并终止执行.
    false,如果引用类型赋值失败,程序不报错,正常执行,引用类型为空(null).
    
 6.Autowired注解可以修饰在哪里?
    CONSTRUCTOR（构造函数），METHOD（方法），
    PARAMETER（参数），FIELD（字段），ANNOTATION_TYPE（注解）
   
 7.怎么读取多个外部属性文件
 1、写多个@PropertySource("classpath:db.properties")
 2、引用@PropertySource里面的value，相当于数组
 
 