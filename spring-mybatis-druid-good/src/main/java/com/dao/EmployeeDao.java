package com.dao;

import com.entity.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeDao {
    List<Employee> getAll(@Param("pageNum")int pageNum,@Param("pageSize")int pageSize);
}
