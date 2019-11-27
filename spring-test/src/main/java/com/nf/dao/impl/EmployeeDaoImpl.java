package com.nf.dao.impl;

import com.nf.dao.EmployeeDao;
import com.nf.entity.Employee;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class EmployeeDaoImpl implements EmployeeDao {
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner){
        this.queryRunner=queryRunner;
    }

    @Override
    public Employee getById() {
        String sql = "select id,username from employee where id =5";

        BeanHandler<Employee> beanHandler = new BeanHandler<>(Employee.class);
        Employee employee = null;
        try {
            employee = queryRunner.query(sql,beanHandler);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }
}
