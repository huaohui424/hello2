package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:/db.properties")
public class DbConfig {

   // @Autowired
    //private Environment environment;


    @Value("${jdbc.username:myroot}")
    private String username;

    public String getData(){
        return username;
         //return environment.getProperty("jdbc.username");
}
}
