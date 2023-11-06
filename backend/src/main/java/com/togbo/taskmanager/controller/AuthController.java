package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.services.AuthService;
import com.togbo.taskmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/register")
public class AuthController {

    public EmployeeService employeeService;
    public AuthService authService;

    public AuthController(EmployeeService employeeService, AuthService authService) {
        this.employeeService = employeeService;
        this.authService = authService;
    }


    @PostMapping("/employee")
    public void registerEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
}
