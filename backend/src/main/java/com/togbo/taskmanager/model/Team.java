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

    private Integer size;
    private String name;

    @OneToMany(mappedBy = "team")
    private Set<Employee> employeesTeam = new HashSet<>();


    public Team() {
    }

    public Team(String name, int size, Set<Employee> employeesTeam) {
        this.name = name;
        this.size = size;
        this.employeesTeam = employeesTeam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", employeesTeam=" + employeesTeam +
                '}';
    }
}
