package factory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("factory.xml");
        A instance0 = context.getBean("first",A.class);

        //静态方法
        A instance = context.getBean("factory",A.class);
        //实例方法
        A instance2 = context.getBean("factory2",A.class);
        //继承一个FactoryBean<T> 的方法
        A instance3 = context.getBean("myfactory",A.class);

        System.out.println(instance0.getClass().getName());
        System.out.println(instance.getClass().getName());
        System.out.println(instance2.getClass().getName());
        System.out.println(instance3.getClass().getName());
    }
}
