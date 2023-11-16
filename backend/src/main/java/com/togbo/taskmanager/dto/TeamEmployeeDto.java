package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class TeamEmployeeDto {

    private String name;

    private Set<Employee> employees = new HashSet<>();

    public TeamEmployeeDto(String name, Set<Employee> employeesTeam) {
        this.name = name;
        this.employees = employeesTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
