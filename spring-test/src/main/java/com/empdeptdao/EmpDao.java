package com.empdeptdao;

import java.sql.Connection;
import java.sql.SQLException;

public interface EmpDao {
    //删除所属部门的所有员工
    int deleteEmpsByDeptId(Connection conn, int id) throws SQLException;
}
