package com.nf.work;

import java.util.Properties;

public class SqlSessionFactorCreator {
    private Properties prop;

    public void setProp(Properties prop){
        this.prop=prop;
    }

    SqlSessionFactory create(){
        return new SqlSessionFactory(prop);
    }

    @Override
    public String toString() {
        return "SqlSessionFactorCreator{" +
                "prop=" + prop +
                '}';
    }
}
