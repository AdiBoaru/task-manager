package main.java.com.togbo.taskmanager.dto;

import main.java.com.togbo.taskmanager.enums.Role;
import main.java.com.togbo.taskmanager.model.Employee;

import java.time.LocalDate;
import java.util.UUID;

public class AccountDto {
    private UUID id;
    private String username;
    private String password;
    private LocalDate createdDate;
    private Role role;
    private Employee employee;

    public AccountDto(UUID id, String username, String password, LocalDate createdDate, Role role, Employee employee) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.role = role;
        this.employee = employee;
    }

    public AccountDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
