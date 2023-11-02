package main.java.com.togbo.taskmanager.dto;

import main.java.com.togbo.taskmanager.enums.Priority;
import main.java.com.togbo.taskmanager.enums.Status;
import main.java.com.togbo.taskmanager.model.Employee;
import main.java.com.togbo.taskmanager.model.Project;

import java.io.File;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class TaskDto {
    private UUID id;
    private String name;
    private String description;
    private File file;
    private LocalDate startDate;
    private LocalDate endDate;
    private Status status;
    private Priority priority;
    private Set<Employee> employees;
    private Project project;

    public TaskDto(UUID id, String name, String description, File file, LocalDate startDate, LocalDate endDate, Status status, Priority priority, Set<Employee> employees, Project project) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.file = file;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
        this.employees = employees;
        this.project = project;
    }

    public TaskDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
