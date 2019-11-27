package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.EmployeeService;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao){
        this.dao=dao;
    }

    @Override
    public List<Employee> getAll(int pageNum, int pageSize) {
        return dao.getAll(pageNum,pageSize);
    }
}
