package com.togbo.taskmanager.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID uuid;
    private String title;
    private String description;

    private LocalDate dueDate;

 //   private Set<Employee> employees;
  //  private Set<Task> tasks;


    public Project(UUID uuid, String title, String description, LocalDate dueDate){// Set<Employee> employees, Set<Task> tasks) {
        this.uuid = uuid;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
    //    this.employees = employees;
     //   this.tasks = tasks;
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

 /*   public Set<Employee> getEmployees() {
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


  */
    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + uuid +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
          //      ", employees=" + employees +
          //      ", tasks=" + tasks +
                '}';
    }
}
