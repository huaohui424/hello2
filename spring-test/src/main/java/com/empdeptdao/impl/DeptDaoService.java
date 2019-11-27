package com.empdeptdao.impl;

import com.empdeptdao.DeptDao;
import com.util.Utils;

import javax.rmi.CORBA.Util;
import java.sql.Connection;
import java.sql.SQLException;

public class DeptDaoService implements DeptDao {

    @Override
    public int deleteDeptById(Connection conn, int deptId) throws SQLException {
        String sql = "delete from dept where id="+deptId;
        return Utils.deleteDept(conn,sql);
    }
}
