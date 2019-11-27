package com.service;

import com.dao.DeptDao;
import com.dao.EmployeeDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Service层
@Service
public class DeptDaoServiceImpl {
    private DeptDao deptDao;
    private EmployeeDao employeeDao;

    public DeptDaoServiceImpl(DeptDao deptDao, EmployeeDao employeeDao){
        this.deptDao=deptDao;
        this.employeeDao=employeeDao;
    }

    /*
    * @Transactional  被事务管理
    * */
    @Transactional
    public void txTest(){
        deptDao.delete();
        employeeDao.insert();
        System.out.println("成功执行！！！");
    }

}
