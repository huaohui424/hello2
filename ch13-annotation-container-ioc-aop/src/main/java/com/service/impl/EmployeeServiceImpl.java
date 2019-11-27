package com.service.impl;

import com.dao.EmployeeDao;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

@Service
@Scope("singleton")
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    @Qualifier("employeeDaoImpl")
    private EmployeeDao dao;

    @Autowired
    private List<EmployeeDao> employeeDaoList;

    @Autowired
    private Map<String,EmployeeDao> employeeDaoMap;

    @Override
    public void update() {
       dao.update();
    }

    @PostConstruct
    public void init(){
        System.out.println("init---");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy---");
    }

    public void displayAutowireCollectionInject(){
        for(EmployeeDao employeeDao : employeeDaoList){
            employeeDao.update();
        }
        System.out.println("---map");
        for(Map.Entry<String,EmployeeDao> entry:employeeDaoMap.entrySet()){
            System.out.println("-----debug: entry.getKey() + \"value: \"+ entry.getValue() = "
                    + entry.getKey() + "value: "+ entry.getValue());
        }
    }
}
