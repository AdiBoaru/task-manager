package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.model.Employee;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class TeamDto {

    private String name;

    private Set<Employee> employeesTeam = new HashSet<>();

    public TeamDto(String name, Set<Employee> employeesTeam) {
        this.name = name;
        this.employeesTeam = employeesTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployeesTeam() {
        return employeesTeam;
    }

    public void setEmployeesTeam(Set<Employee> employeesTeam) {
        this.employeesTeam = employeesTeam;
    }
}
