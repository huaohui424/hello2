package com.dao;

import com.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    void insert(Employee employee);

    List<Employee> getAll();
}
