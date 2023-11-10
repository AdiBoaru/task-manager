package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.AccountEmployeeDTO;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/register")
public class AuthController {
    public final AccountRepository accountRepository;
    public final EmployeeRepository employeeRepository;

    @Autowired
    public EmailService emailService;
    public AuthController(AccountRepository accountRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
    }

    //make use of a mapper
   /* @PostMapping("/employee")
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
    */
    @GetMapping("/login")
    public Employee loginEmployee(@RequestBody AccountEmployeeDTO accountEmployeeDTO){
        //find email
        //find password

        accountRepository.findByEmail(accountEmployeeDTO.getEmail());
            return null;
    }
    @PostMapping("/account")
    public String processRegister(@RequestBody AccountEmployeeDTO accountEmployeeDTO, HttpServletRequest httpServletRequest)
            throws UnsupportedEncodingException, MessagingException, ResourceNotFoundException {
        emailService.register(accountEmployeeDTO, getSiteURL(httpServletRequest));
        return "register_success";
    }

    private String getSiteURL(HttpServletRequest request) {
        String url = "http://localhost:5173/login";
        String siteURL = request.getRequestURL().toString();
        //return siteURL.replace(request.getServletPath(), "");
        return url;
    }
}
