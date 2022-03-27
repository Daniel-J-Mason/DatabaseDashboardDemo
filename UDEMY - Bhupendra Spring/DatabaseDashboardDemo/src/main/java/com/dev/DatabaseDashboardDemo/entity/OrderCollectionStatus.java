package com.dev.DatabaseDashboardDemo.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "OrderCollectionStatus", schema = "SpringBootLearning")
public class OrderCollectionStatus extends KeyEntity {
    
    private int newOrders;
    private double revenue;
    private int shipped;
    private int returned;
    
    public int getNewOrders() {
        return newOrders;
    }
    
    public void setNewOrders(int newOrders) {
        this.newOrders = newOrders;
    }
    
    public double getRevenue() {
        return revenue;
    }
    
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    public int getShipped() {
        return shipped;
    }
    
    public void setShipped(int shipped) {
        this.shipped = shipped;
    }
    
    public int getReturned() {
        return returned;
    }
    
    public void setReturned(int returned) {
        this.returned = returned;
    }
}
