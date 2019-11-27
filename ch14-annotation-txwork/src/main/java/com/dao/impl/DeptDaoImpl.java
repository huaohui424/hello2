package com.dao.impl;

import com.dao.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
//Dao层  @Repository将Dao导入IOC
@Repository
public class DeptDaoImpl implements DeptDao {
    //自动注入JdbcTemplate
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void delete() {
        String sql = "delete from dept where id = 1";
        jdbcTemplate.update(sql);
    }
}
