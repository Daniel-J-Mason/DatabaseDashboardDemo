package com.dev.DatabaseDashboardDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="EmployeeInformation", schema = "SpringBootLearning")
public class EmployeeInformation extends KeyEntity{
    private String _name;
    private String position;
    private String officeLocation;
    private int age;
    private Date startDate;
    private double salary;
    
    public String get_name() {
        return _name;
    }
    
    public void set_name(String _name) {
        this._name = _name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    public String getOfficeLocation() {
        return officeLocation;
    }
    
    public void setOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
