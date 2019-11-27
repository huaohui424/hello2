package com.service.impl;

import com.dao.DeptDao;
import com.dao.EmployeeDao;
import com.entity.Employee;
import com.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DeptDao deptDao;

    @Override
    public List<Employee> getAll(int pageNum, int pageSize) {
        return employeeDao.getAll(pageNum,pageSize);
    }

    @Transactional
    @Override
    public void txDemo() {
        deptDao.delete();
        employeeDao.insert();
    }
}
