package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.AccountEmployeeDto;
import com.togbo.taskmanager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AccountEmployeeMapper implements Function<Employee, AccountEmployeeDto> {
    @Override
    public AccountEmployeeDto apply(Employee employee) {
        return null; /*new AccountEmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthDate(),
                employee.getRole());
*/
    }
}
