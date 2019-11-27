package com.service;

import com.dao.RetiredSataffDao;
import com.dao.StaffDao;
import com.entity.Staff;

import java.util.List;

public class StaffInsertAndDeleteManager {
    private RetiredSataffDao retiredSataffDao;
    private StaffDao staffDao;

    public void setRetiredSataffDao(RetiredSataffDao retiredSataffDao) {
        this.retiredSataffDao = retiredSataffDao;
    }

    public void setStaffDao(StaffDao staffDao) {
        this.staffDao = staffDao;
    }

    public List<Staff> getAll(int pageNum, int pageSize){
        return staffDao.getAll(pageNum,pageSize);
    }

    public void insert(Staff staff) {
        staffDao.insert(staff);
    }

    public void deleteById(int id){
        Staff staff = staffDao.getById(id);
        retiredSataffDao.insert(staff);
        staffDao.deleteById(id);
    }

}
