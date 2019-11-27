package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        EmployeeDao dao = context.getBean("first",EmployeeDao.class);
        EmployeeDao dao2 = context.getBean("first",EmployeeDao.class);


        System.out.println(dao);
        System.out.println(dao2);
    }
}
