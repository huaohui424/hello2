package com.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;

public class DeptDaoImpl extends BaseDao{

    public void deleteById(int id) throws Exception {
        String sql = "delete from dept where id=?";
        //throwEx();
        jdbcTemplate.update(sql,id);
    }

    private void throwEx() throws Exception {
        throw new MyCheckEx();
    }
}
