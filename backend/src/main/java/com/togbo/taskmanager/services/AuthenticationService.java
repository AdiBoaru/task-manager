package com.togbo.taskmanager.services;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.repository.AccountRepository;
import com.togbo.taskmanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
/*
@Service
public class AuthenticationService {

    public EmployeeRepository employeeRepository;

    public AccountRepository accountRepository;

    public AuthenticationService(EmployeeRepository employeeRepository, AccountRepository accountRepository) {
        this.employeeRepository = employeeRepository;
        this.accountRepository = accountRepository;
    }

    public void registerEmployeeAccount(Employee employee, Account account){
        Account accountRegistered = accountRepository.save(account);

        employee.setAccount(accountRegistered);

        employeeRepository.save(employee);
    }
}



 */