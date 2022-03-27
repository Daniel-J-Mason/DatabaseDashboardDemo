package com.dev.DatabaseDashboardDemo.service;

import com.dev.DatabaseDashboardDemo.entity.*;

import java.util.HashMap;
import java.util.List;

public interface DashboardService {
    
    Credentials addUser(String username, String password);
    
    HashMap<String, Object> getRevenueDash();
    
    List<EmployeeInformation> getAllEmployees();
    
    String getAllEmployeesAsList();
    
    EmployeeInformation getEmployeeByPK(String pk);
    
    EmployeeInformation addEmployee(EmployeeInformation employeeInformation);
    
    EmployeeInformation updateEmployee(EmployeeInformation employeeInformation);
    
    void deleteEmployee(EmployeeInformation employeeInformation);
    
    List<OrderCollectionStatus> getOrderCollection();
    
    List<OrderReceived>getAllOrdersReceived();
    
    List<ProductCategory> getBestCategory();
}
