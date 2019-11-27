package com.empdeptdao.impl;

import com.empdeptdao.EmpDao;
import com.util.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class EmpDaoServiceimpl implements EmpDao {

    @Override
    public int deleteEmpsByDeptId(Connection conn, int id) throws SQLException {
        String sql = "depete from employee where id="+id;
        return Utils.deleteDept(conn,sql);
    }
}
