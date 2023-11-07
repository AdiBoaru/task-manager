package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.Account;
import com.togbo.taskmanager.model.Project;

import java.time.LocalDate;
import java.util.Set;

public class AccountEmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate createdDate;
    private Role role;
    private String email;
    private String password;

    public AccountEmployeeDTO(Long id, String firstName, String lastName, LocalDate birthDate, LocalDate createdDate, Role role, String email, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.createdDate = createdDate;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}