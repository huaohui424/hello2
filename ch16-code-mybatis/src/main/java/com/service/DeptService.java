package com.service;

import com.entity.Employee;

import java.util.List;

public interface DeptService {
    List<Employee> getAll(int pageNum,int pageSize);

    void txDemo();
}
