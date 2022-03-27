package com.dev.DatabaseDashboardDemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CompanyRevenue", schema = "SpringBootLearning")
public class CompanyRevenue extends KeyEntity {
    
    @Column(name = "Revenue_Month", nullable = false)
    private String _month;
    
    @Column(name = "revenue", nullable = false)
    private double revenue;
    
    @Column(name = "expense")
    private double expense;
    
    @Column(name = "margins")
    private double margins;
    
    public String get_month() {
        return _month;
    }
    
    public void set_month(String _month) {
        this._month = _month;
    }
    
    public double getRevenue() {
        return revenue;
    }
    
    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }
    
    public double getExpense() {
        return expense;
    }
    
    public void setExpense(double expense) {
        this.expense = expense;
    }
    
    public double getMargins() {
        return margins;
    }
    
    public void setMargins(double margins) {
        this.margins = margins;
    }
}
