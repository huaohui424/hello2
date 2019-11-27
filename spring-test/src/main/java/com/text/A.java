package com.text;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class A implements FactoryBean<A>, InitializingBean {
    private static B ainstance = new B();
    private C c;

    public A(){}

    public A(B ainstance){
        this.ainstance=ainstance;
    }

    public static B createB(){
        return ainstance;
    }


    @Override
    public A getObject() throws Exception {
        System.out.println("----getObject");
        return new A();
    }

    @Override
    public Class<?> getObjectType() {
        System.out.println("----getType");
        return A.class;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after---InitializingBean");
    }


}
