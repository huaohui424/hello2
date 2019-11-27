package com.service;

import com.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll(int pageNum,int pageSize);
}
