package com.nf.complex;

public class UserServiceImpl implements UserService {
    private UserDao dao;

    public void setDao(UserDao dao){
        this.dao=dao;
    }


    @Override
    public void update() {

    }


}
