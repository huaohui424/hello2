package com.lianxi.service.impl;

import com.lianxi.dao.DeptDao;
import com.lianxi.entity.Dept;
import com.lianxi.service.DeptService;

import javax.sql.DataSource;

public class DeptServiceImpl implements DeptService {
    private DeptDao dao;
    public void setDao(DeptDao dao){
        this.dao=dao;
    }

    @Override
    public Dept getById() {
        return dao.getById();
    }
}
