package com.pojo.order.entity;

import io.swagger.models.auth.In;

public class User {

    private Long id;

    private Long password;

    private Integer state;

    public User() {
    }

    public User(Long id, Long password,Integer state) {
        this.id = id;
        this.password = password;
        this.state=state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPassword() {
        return password;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", password=" + password +
                ", state=" + state +
                '}';
    }
}
