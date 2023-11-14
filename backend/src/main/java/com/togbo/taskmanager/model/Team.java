package com.togbo.taskmanager.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Employee> employeesTeam = new HashSet<>();


    public Team(String name, Set<Employee> employeesTeam) {
        this.name = name;
        this.employeesTeam = employeesTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employeesTeam;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employeesTeam = employees;
    }
}
