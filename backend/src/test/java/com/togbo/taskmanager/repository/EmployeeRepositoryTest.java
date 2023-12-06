package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AccountRepository accountRepository;

    @Test
    @Transactional
    void findEmployeeByAccount() {
        //given
        String email = "test@yahoo.com";
        Account account = new Account(email, "12345", Role.DEVELOPER);
        accountRepository.save(account);
        Employee employee = new Employee("Mike", "Test", LocalDate.now(), account);
        employeeRepository.save(employee);

        //when
        Employee employeeExists = employeeRepository.findByAccount(account);

        //then
        Assertions.assertNotNull(employeeExists);
        Assertions.assertEquals("Mike", employee.getFirstName());
        Assertions.assertEquals("Test", employee.getLastName());

    }

}
