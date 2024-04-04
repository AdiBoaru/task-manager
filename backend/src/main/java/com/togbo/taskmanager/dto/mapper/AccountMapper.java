package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.function.Function;

public class AccountMapper{

    public static Account mapToAccount(AccountEmployeeDto accountEmployeeDto){
        return new Account(
                accountEmployeeDto.getEmail(),
                accountEmployeeDto.getPassword(),
                accountEmployeeDto.getRole(),
                accountEmployeeDto.getImage()
        );
    }

}
