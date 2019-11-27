package com.service.ipml;

import com.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public int add(int x, int y) {
        System.out.println("impl add---");
        return x+y;
    }
}
