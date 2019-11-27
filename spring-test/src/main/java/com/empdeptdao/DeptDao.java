package com.empdeptdao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DeptDao {
    //删除某个部门
    int deleteDeptById(Connection conn, int deptId) throws SQLException;
}
