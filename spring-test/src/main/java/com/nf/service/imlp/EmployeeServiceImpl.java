package com.nf.service.imlp;

import com.nf.dao.EmployeeDao;
import com.nf.entity.Employee;
import com.nf.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDao employeeDao;
    public void setEmployeeDao(EmployeeDao employeeDao){
        this.employeeDao=employeeDao;
    }

    @Override
    public Employee getById() {
        return employeeDao.getById();
    }
}
