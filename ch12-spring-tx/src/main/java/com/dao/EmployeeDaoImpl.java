package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

public class EmployeeDaoImpl extends BaseDao{
    public void deleteByDeptId(int id){
        String sql = "delete from employee where deptid=?";
        jdbcTemplate.update(sql,id);
    }

}
