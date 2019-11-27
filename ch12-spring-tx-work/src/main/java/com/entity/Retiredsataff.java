package com.entity;

import java.math.BigDecimal;

public class Retiredsataff {
    private int id;
    private String name;
    private int state;

    @Override
    public String toString() {
        return "retiredSataff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
