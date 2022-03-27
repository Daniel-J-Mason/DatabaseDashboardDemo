package com.dev.DatabaseDashboardDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OrderReceived", schema = "SpringBootLearning")
public class OrderReceived extends KeyEntity{
    
    private int orderReceived;
    private String dateReceived;
    
    public int getOrderRecieved() {
        return orderReceived;
    }
    
    public void setOrderRecieved(int orderRecieved) {
        this.orderReceived = orderRecieved;
    }
    
    public String getDateRecieved() {
        return dateReceived;
    }
    
    public void setDateRecieved(String dateReceived) {
        this.dateReceived = dateReceived;
    }
}
