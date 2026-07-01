package com.eurs.project.controller;

import com.eurs.project.model.Employee;
import com.eurs.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public String registerEmployee(@RequestBody Employee theEmployee){
        return employeeService.registerEmployee(theEmployee);
    }

    @GetMapping("/")
    public String simple(){
        return "yo";
    }

}
