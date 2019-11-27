package com.dao.impl;

import com.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//Dao层  @Repository将Dao导入IOC
@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    //自动注入
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insert() {
        String sql = "insert into employee(username) values('abasdfsadfadsdfasc')";
        jdbcTemplate.update(sql);
    }
}
