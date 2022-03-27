package com.dev.DatabaseDashboardDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Credentials", schema = "SpringBootLearning")
public class Credentials extends KeyEntity{
    String username;
    String password;
    String role;
    
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
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
}
