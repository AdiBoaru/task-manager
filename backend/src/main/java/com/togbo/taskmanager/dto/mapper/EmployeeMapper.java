package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;

public class EmployeeMapper {

    public static Employee mapToEmployee(AccountEmployeeDto accountEmployeeDto, Account account){
        return new Employee(
                accountEmployeeDto.getFirstName(),
                accountEmployeeDto.getLastName(),
                accountEmployeeDto.getBirthDate(),
                account
        );
    }
}
