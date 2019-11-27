package com.entity;

import java.util.List;

public class EmpVO {
    List<Emp> emps;

    @Override
    public String toString() {
        return "EmpVO{" +
                "emps=" + emps +
                '}';
    }

    public List<Emp> getEmps() {
        return emps;
    }

    public void setEmps(List<Emp> emps) {
        this.emps = emps;
    }
}
