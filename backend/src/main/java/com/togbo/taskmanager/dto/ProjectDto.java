package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.Set;

public class ProjectDto {
    private String title;
    private String description;
    private LocalDate dueDate;
    private Integer teamSize;
    private Set<Employee> employees;
    private Set<Task> tasks;

    public ProjectDto(String title, String description, LocalDate dueDate, Integer teamSize, Set<Employee> employees, Set<Task> tasks) {
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.teamSize = teamSize;
        this.employees = employees;
        this.tasks = tasks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTeamSize() {
        return teamSize;
    }

    public void setTeamSize(Integer teamSize) {
        this.teamSize = teamSize;
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
