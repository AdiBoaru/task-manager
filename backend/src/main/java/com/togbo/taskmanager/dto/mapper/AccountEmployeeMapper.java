package com.togbo.taskmanager.dto.mapper;

import com.togbo.taskmanager.dto.AccountEmployeeDTO;
import com.togbo.taskmanager.dto.EmployeeDTO;
import com.togbo.taskmanager.model.Employee;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class AccountEmployeeMapper implements Function<Employee, AccountEmployeeDTO> {
    @Override
    public AccountEmployeeDTO apply(Employee employee) {
        return null; /*new AccountEmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getBirthDate(),
                employee.getRole());
*/
    }
}
