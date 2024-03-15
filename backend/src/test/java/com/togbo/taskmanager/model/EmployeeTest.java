package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    @DisplayName("Creating Employee with 4 params")
    void createEmployeeCallingConstructorWith4Param(){
        //given
        String firstName = "Max";
        String lastName = "Ords";
        LocalDate localDate = LocalDate.of(1993,3,12);
        Account account = new Account();

        //when
        Employee employee = new Employee(firstName,lastName,localDate,account);

        //then
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(localDate, employee.getBirthDate());
        assertEquals(account, employee.getAccount());
    }

    @Test
    @Disabled("Implementation not finished")
    void testGetterAndSetter(){
        //given
        Employee employee = new Employee();
        Long id = 5L;
        String firstName = "Marco";
        String lastName = "User";
        LocalDate birthDate = LocalDate.of(2011,3,23);

        //when
        employee.setId(id);
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setBirthDate(birthDate);

        //then
        assertEquals(id, employee.getId());
        assertEquals(firstName, employee.getFirstName());
        assertEquals(lastName, employee.getLastName());
        assertEquals(birthDate, employee.getBirthDate());
    }
}