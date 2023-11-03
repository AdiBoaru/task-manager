package com.togbo.taskmanager.model;

import jakarta.persistence.*;
import main.java.com.togbo.taskmanager.enums.Priority;
import main.java.com.togbo.taskmanager.enums.Status;

import java.io.File;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String name;
    private String description;
    private File file;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    private Status status;
    private Priority priority;

    public Task() {
    }

    public Task(UUID id,
                String name,
                String description,
                File file,
                LocalDate startDate,
                LocalDate endDate,
                Status status,
                Priority priority) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.file = file;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.priority = priority;
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

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", file=" + file +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", status=" + status +
                ", priority=" + priority +
                '}';
    }
}
