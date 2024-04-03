package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Task;
import com.togbo.taskmanager.model.Team;

import java.time.LocalDate;
import java.util.Set;

public class ProjectDto {
    private String name;
    private String description;
    private LocalDate dueDate;
    private Team team;
    private Set<Employee> employees;
    private Set<Task> tasks;

    public ProjectDto(String title, String description, LocalDate dueDate, Team teamSize, Set<Employee> employees, Set<Task> tasks) {
        this.name = title;
        this.description = description;
        this.dueDate = dueDate;
        this.team = teamSize;
        this.employees = employees;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
