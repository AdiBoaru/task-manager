package com.togbo.taskmanager.dto;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import com.togbo.taskmanager.model.Employee;
import com.togbo.taskmanager.model.Project;

import java.io.File;
import java.time.LocalDate;
import java.util.Set;

public class TaskDto {
    private Long id;
    private String name;
    private String description;
    private File file;
    private LocalDate startDate;
    private LocalDate dueDate;
    private Status status;
    private Priority priority;
    private Set<Employee> employees;
    private Project project;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
