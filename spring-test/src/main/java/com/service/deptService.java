package com.service;

import com.empdeptdao.DeptDao;
import com.empdeptdao.EmpDao;

import java.sql.Connection;
import java.sql.SQLException;

public class deptService {
    private DeptDao deptDao;
    private EmpDao empDao;

    public void setDeptDao(DeptDao deptDao){
        this.deptDao=deptDao;
    }
    public void setEmpDao(EmpDao empDao){
        this.empDao=empDao;
    }

    public void delete(Connection connection,int id) throws SQLException {
        deptDao.deleteDeptById(connection,id);
        empDao.deleteEmpsByDeptId(connection,id);
    }

}
