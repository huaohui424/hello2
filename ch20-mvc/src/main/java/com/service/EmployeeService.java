package com.service;

import com.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void insert(Employee employee);

    List<Employee> getAll();
}
