package com.dev.DatabaseDashboardDemo.controller;

import com.dev.DatabaseDashboardDemo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    
    @Autowired
    private DashboardService dashboardService;
    
    @GetMapping(value = "/dashboard")
    public String getDashDetail(Model model){
        
        model.addAttribute("cr", dashboardService.getRevenueDash());
        model.addAttribute("ei", dashboardService.getAllEmployeesAsList());
        return "/dashboard";
    }
}
