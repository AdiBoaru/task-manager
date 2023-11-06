package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Priority;
import com.togbo.taskmanager.enums.Status;
import jakarta.persistence.*;

import java.io.File;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID uuid;

    private Long id;
    private String name;
    private String description;
    private File file;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @ManyToMany(mappedBy = "tasks")
    private Set<Employee> employees = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task() {
    }

    public Task(Long id, String name, String description, File file, LocalDate startDate, LocalDate dueDate, Status status, Priority priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.file = file;
        this.startDate = startDate;
        this.dueDate = dueDate;
        this.status = status;
        this.priority = priority;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + uuid +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", file=" + file +
                ", startDate=" + startDate +
                ", endDate=" + dueDate +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
