package main.java.com.togbo.taskmanager.dto;

import main.java.com.togbo.taskmanager.model.Employee;
import main.java.com.togbo.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class ProjectDto {
    private UUID uuid;
    private String title;
    private String description;
    private LocalDate dueDate;
    private Set<Employee> employees;
    private Set<Task> tasks;

    public ProjectDto(UUID uuid, String title, String description, LocalDate dueDate, Set<Employee> employees, Set<Task> tasks) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.employees = employees;
        this.tasks = tasks;
    }

    public ProjectDto() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
