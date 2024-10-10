package com.me.springsecurity.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MyUser {
    @Id
    private String userId;
    private String username;
    private String password;
    private String rollNumber;
    private String role;
    public MyUser(String username, String rollNumber, String role, String password) {
        super();
        this.username = username;
        this.password = password;
        this.rollNumber = rollNumber;
        this.role = role;
    }
    public String getUserId() {
        return userId;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRollNumber() {
        return rollNumber;
    }
    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
