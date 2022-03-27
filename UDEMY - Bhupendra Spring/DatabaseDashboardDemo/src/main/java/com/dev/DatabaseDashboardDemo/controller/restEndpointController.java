package com.dev.DatabaseDashboardDemo.controller;

import com.dev.DatabaseDashboardDemo.entity.EmployeeInformation;
import com.dev.DatabaseDashboardDemo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class restEndpointController {
    
    @Autowired
    private DashboardService dashboardService;
    
    @RequestMapping(value = "/employees")
    public List<EmployeeInformation> getAllEmployees(){
        return dashboardService.getAllEmployees();
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/employee/add")
    public String saveEmployee(@RequestBody EmployeeInformation employeeInformation){
        if(dashboardService.addEmployee(employeeInformation) != null){
            return "Employee saved successfully!";
        } else {
            return "Error saving employee info";
        }
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "employee/addMultiple")
    public String saveMulipleEmployees(@RequestBody List<EmployeeInformation> employeeInformationList){
        for (EmployeeInformation employee: employeeInformationList){
            saveEmployee(employee);
        }
        return "Employees saved";
    }
    
    @RequestMapping(method = RequestMethod.PUT, value = "/employee/delete")
    public String deleteEmployee(@RequestParam(value = "employeeId", required = true) String pk){
        try {
            dashboardService.deleteEmployee(dashboardService.getEmployeeByPK(pk));
            return "Employee deleted successfully";
        } catch (Exception e) {
            return "Error";
        }
    }
}
