package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    Employee findByAccount(Account account);
}
