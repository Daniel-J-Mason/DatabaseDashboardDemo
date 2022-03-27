package com.dev.DatabaseDashboardDemo.controller;

import com.dev.DatabaseDashboardDemo.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class CreateUserController {
    
    @Autowired
    private DashboardService dashboardService;
    
    @GetMapping("/createUser")
    public String root(){
        return "createUser";
    }
    
    @RequestMapping(method = RequestMethod.POST, value="/createUser")
    public RedirectView createUser(@RequestParam(value = "username", required = true) String username,
                             @RequestParam(value = "password", required = true) String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String localpassword = encoder.encode(password);
        if(dashboardService.addUser(username, localpassword) != null){
            return new RedirectView("/login");
        }
        
        return new RedirectView("/createUser");
    }
}
