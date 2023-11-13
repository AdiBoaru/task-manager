package com.togbo.taskmanager.repository;

import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    @Query(value = "SELECT e.* FROM employees e where e.account_id = :accountId", nativeQuery = true)
    Employee findEmployeeByAccount(@Param("accountId")Long accountId);
    Employee findByAccount(Account account);
}
