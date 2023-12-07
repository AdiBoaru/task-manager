package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AccountRepository accountRepository;
    Employee employee;
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("test@yahoo.com", "12345", Role.DEVELOPER);
        employee = new Employee("Mike", "Lin", LocalDate.now(), account);
        accountRepository.save(account);
        employeeRepository.save(employee);

    }

    @AfterEach
    void tearDown() {
        account = null;
        employee = null;

        accountRepository.deleteAll();
        employeeRepository.deleteAll();
    }

    //Success
    @Test
    void testFindEmployeeByAccount() {
        Employee employeeExist = employeeRepository.findByAccount(account);

        assertThat(account).isEqualTo(employeeExist.getAccount());
        assertThat(account.getEmail()).isEqualTo(employeeExist.getAccount().getEmail());
        assertThat(employeeExist.getFirstName()).isEqualTo("Mike");
        assertThat(employeeExist.getLastName()).isEqualTo("Lin");

    }

    //Failure
    @Test
    void testFindEmployeeByAccountFailure() {
        Employee employeeExist = employeeRepository.findByAccount(account);

        assertThat(employeeExist.getAccount().getEmail()).isNotEqualTo("mk@test@yahoo.com");
        assertThat(employeeExist.getFirstName()).isNotEqualTo("Kuiv");
        assertThat(employeeExist.getLastName()).isNotEqualTo("An");
    }

}
