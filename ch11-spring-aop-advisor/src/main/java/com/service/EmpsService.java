package com.service;

import java.sql.Connection;

public interface EmpsService {
    int deleteDeptWithEmps(Connection conn, int deptid);
}
