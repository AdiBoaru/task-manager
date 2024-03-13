package com.togbo.taskmanager.controller;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.exceptions.ResourceNotFoundException;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import com.togbo.taskmanager.services.EmailService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/register")
public class AuthenticationController {
    public final AccountRepository accountRepository;
    public final EmployeeRepository employeeRepository;

    @Autowired
    public EmailService emailService;
    public AuthenticationController(AccountRepository accountRepository, EmployeeRepository employeeRepository) {
        this.accountRepository = accountRepository;
        this.employeeRepository = employeeRepository;
    }

    //make use of a mapper
   @PostMapping("/employee")
    public void registerEmployee(@RequestBody AccountEmployeeDto accountEmployeeDTO){
        Account account = new Account();
        account.setEmail(accountEmployeeDTO.getEmail());
        account.setPassword(accountEmployeeDTO.getPassword());
        account.setCreatedDate(accountEmployeeDTO.getCreatedDate());

        Employee employee = new Employee();
        employee.setId(accountEmployeeDTO.getId());
        employee.setFirstName(accountEmployeeDTO.getFirstName());
        employee.setLastName(accountEmployeeDTO.getLastName());
        employee.setBirthDate(accountEmployeeDTO.getBirthDate());
     //   employee.set(accountEmployeeDTO.getRole());
        employee.setAccount(account);

        accountRepository.save(account);
        employeeRepository.save(employee);
    }
    @PostMapping("/login")
    public Employee loginEmployee(@RequestBody AccountEmployeeDto accountEmployeeDTO) throws ResourceNotFoundException {
        Account account = accountRepository.findByEmail(accountEmployeeDTO.getEmail());
        Employee employee = null;
        if(account != null){
            if(account.getPassword().equals(accountEmployeeDTO.getPassword())){
                employee = employeeRepository.findByAccount(account);
            }else
                throw new ResourceNotFoundException("bad request");
        }
        return employee;
    }
    @PostMapping("/account")
    public String processRegister(@RequestBody AccountEmployeeDto accountEmployeeDTO, HttpServletRequest httpServletRequest)
            throws UnsupportedEncodingException, ResourceNotFoundException {
        try {
            emailService.register(accountEmployeeDTO, getSiteURL(httpServletRequest));
            return "register_success";
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace(); // or use a logging framework
            return "register_failure";
        }
    }

    private String getSiteURL(HttpServletRequest request) {
        String url = "http://localhost:5173/login";
        String siteURL = request.getRequestURL().toString();
        //return siteURL.replace(request.getServletPath(), "");
        return url;
    }
}

