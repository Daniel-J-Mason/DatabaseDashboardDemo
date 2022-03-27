package com.dev.DatabaseDashboardDemo.service.impl;

import com.dev.DatabaseDashboardDemo.entity.*;
import com.dev.DatabaseDashboardDemo.repositories.*;
import com.dev.DatabaseDashboardDemo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

@Service
public class DashboardServiceImpl implements DashboardService {
    
    @Autowired
    private CompanyRevenueRepository companyRevenueRepository;
    
    @Autowired
    private EmployeeInformationRepository employeeInformationRepository;
    
    @Autowired
    private OrderCollectionStatusRepository orderCollectionStatusRepository;
    
    @Autowired
    private OrderReceivedRepository orderReceivedRepository;
    
    @Autowired
    private ProductCategoryRepository productCategoryRepository;
    
    @Autowired
    private CredentialsRepository credentialsRepository;
    
    //This is a bit spaghetti'd, but a very quick test case on how to add a create user page
    @Override
    public Credentials addUser(String username, String password) {
        Credentials credentials = new Credentials();
        credentials.setPk("3");
        credentials.setUsername(username);
        credentials.setPassword(password);
        credentials.setRole("ROLE_USER");
        return credentialsRepository.save(credentials);
    }
    
    @Override
    public HashMap<String, Object> getRevenueDash() {
        HashMap<String, Object> populateCompanyRevenue = new HashMap<>();
        
        List<CompanyRevenue> companyRevenueList = companyRevenueRepository.findAll();
        
        //Create all the variables needed by the graph view
        List<String> label = new ArrayList<>();
        List<String> revenue = new ArrayList<>();
        
        //Below arent used in the bootstrap 5 sb admin, whoops
        //Leaving there for reference, may use in future if i edit the website
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;
        
        Locale locale = new Locale("en", "US");
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        
        for(CompanyRevenue companyRevenue: companyRevenueList){
            label.add(companyRevenue.get_month());
            revenue.add(String.valueOf(companyRevenue.getRevenue()));
            totalMargin += companyRevenue.getMargins();
            totalExpense += companyRevenue.getExpense();
            totalRevenue += companyRevenue.getRevenue();
        }
        
        populateCompanyRevenue.put("crLabels", label.toString());
        populateCompanyRevenue.put("crRevenue", revenue.toString());
        populateCompanyRevenue.put("totalMargin", currencyFormatter.format(totalMargin));
        populateCompanyRevenue.put("totalExpense", currencyFormatter.format(totalExpense));
        populateCompanyRevenue.put("totalRevenue", currencyFormatter.format(totalRevenue));
        
        
        return populateCompanyRevenue;
    }
    
    @Override
    public List<EmployeeInformation> getAllEmployees() {
        return employeeInformationRepository.findAll();
    }
    
    @Override
    public String getAllEmployeesAsList() {
        StringBuilder employeesAsList = new StringBuilder();
        List<EmployeeInformation> employees = getAllEmployees();
        
        for(EmployeeInformation employee: employees){
            ArrayList<String> current = new ArrayList<>();
            current.add(employee.get_name());
            current.add(String.valueOf(employee.getAge()));
            current.add(employee.getOfficeLocation());
            current.add(employee.getPosition());
            current.add(String.valueOf(employee.getSalary()));
            current.add(String.valueOf(employee.getStartDate()));
            employeesAsList.append(current).append(";");
        }
        
        return employeesAsList.toString();
    }
    
    @Override
    public EmployeeInformation getEmployeeByPK(String pk) {
        return employeeInformationRepository.findByPk(pk);
    }
    
    @Override
    public EmployeeInformation addEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }
    
    @Override
    public EmployeeInformation updateEmployee(EmployeeInformation employeeInformation) {
        return employeeInformationRepository.save(employeeInformation);
    }
    
    @Override
    public void deleteEmployee(EmployeeInformation employeeInformation) {
        employeeInformationRepository.delete(employeeInformation);
    }
    
    @Override
    public List<OrderCollectionStatus> getOrderCollection() {
        return orderCollectionStatusRepository.findAll();
    }
    
    @Override
    public List<OrderReceived> getAllOrdersReceived() {
        return orderReceivedRepository.findAll();
    }
    
    @Override
    public List<ProductCategory> getBestCategory() {
        return productCategoryRepository.findByBestCategory(true);
    }
    
    
}
