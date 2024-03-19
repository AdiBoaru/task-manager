package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class TeamEmployeeDto {

    private String name;

    private int size;
    private Set<Employee> employees;

    public TeamEmployeeDto(String name, int size, Set<Employee> employeesTeam) {
        this.name = name;
        this.size = size;
        this.employees = employeesTeam;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
