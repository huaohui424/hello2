package com.service.impl;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeServiceImpl implements EmployeeDao{
    private EmployeeDao dao;

    public void setDao(EmployeeDao dao){
        this.dao=dao;
    }


    @Override
    public Employee getById() {
        return dao.getById();
    }
}
