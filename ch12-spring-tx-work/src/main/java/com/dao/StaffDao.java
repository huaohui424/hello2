package com.dao;

import com.entity.Staff;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StaffDao {
    List<Staff> getAll(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);

    Staff getById(int id);

    int deleteById(int id);

    void insert(Staff staff);
}
