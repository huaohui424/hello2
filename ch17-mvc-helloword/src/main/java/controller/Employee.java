package controller;

import org.springframework.lang.Nullable;

public class Employee {

    private String name;
    public void helloword(){
        System.out.println("hello word!!");
    }

    public void setViewName(@Nullable String viewName) {
        this.name = viewName;
    }

    @Nullable
    public String getViewName() {
        return this.name instanceof String ? (String)this.name : null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                '}';
    }
}
