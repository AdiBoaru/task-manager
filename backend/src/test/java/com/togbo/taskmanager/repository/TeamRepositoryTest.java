package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Team;
import net.bytebuddy.matcher.FilterableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
class TeamRepositoryTest {
    @Autowired
    private TeamRepository teamRepository;
    Team team;
    Set<Employee> employees;
    Account account;

    @BeforeEach
    void setUp() {
        account = new Account("test@yahoo.com", "12345", Role.DEVELOPER);
        employees = new HashSet<>();
        employees.add(new Employee("Les", "Des", LocalDate.now(), account));
        team = new Team("Team Name",3,employees);

        teamRepository.save(team);
    }

    @AfterEach
    void tearDown() {
        team = null;
        account = null;
        employees = null;
        teamRepository.deleteAll();
    }

    @Test
    void findByName() {
        String name = "Team Name";
        Team teamExist = teamRepository.findByName(name);

        assertThat(teamExist.getName()).isEqualTo(name);
        assertThat(teamExist.getEmployees().iterator().next().getFirstName()).isEqualTo("Les");
    }
}