package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.AccountEmployeeDTO;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.services.AuthService;
import com.togbo.taskmanager.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/register")
public class AuthController {

    public final AccountRepository accountRepository;
    public final EmployeeRepository employeeRepository;

    public AuthController(AccountRepository accountRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
    }

    @PostMapping("/employee")
    public void registerEmployee(@RequestBody AccountEmployeeDTO accountEmployeeDTO){
        Account account = new Account();
        account.setEmail(accountEmployeeDTO.getEmail());
        account.setPassword(accountEmployeeDTO.getPassword());
        account.setCreatedDate(accountEmployeeDTO.getCreatedDate());

        Employee employee = new Employee();
        employee.setId(accountEmployeeDTO.getId());
        employee.setFirstName(accountEmployeeDTO.getFirstName());
        employee.setLastName(accountEmployeeDTO.getLastName());
        employee.setBirthDate(accountEmployeeDTO.getBirthDate());
        employee.setRole(accountEmployeeDTO.getRole());
        employee.setAccount(account);

        accountRepository.save(account);
        employeeRepository.save(employee);
    }
}
