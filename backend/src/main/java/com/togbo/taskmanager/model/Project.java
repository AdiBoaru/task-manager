package com.togbo.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
  /*  @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID uuid;

   */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 2, message = "Title should have at least 2 characters")
    private String title;
    @NotNull
    @Size(min = 2, message = "Description should have at least 2 characters")
    private String description;
    @NotNull
    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "team_size")
    private Integer teamSize;
    @Column(name = "due_date")
    private LocalDate dueDate;
    @ManyToMany
    @JoinTable(
            name = "employee_project",
            joinColumns = @JoinColumn(name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id")
    )
    private final Set<Employee> employees = new HashSet<>();
    @OneToMany(mappedBy = "project")
    private Set<Task> tasks = new HashSet<>();

    public Project() {
    }


    public Project(String title, String description, Integer teamSize,LocalDate dueDate) {
        this.title = title;
        this.description = description;
        this.teamSize = teamSize;
        this.creationDate = LocalDate.now();
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
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

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Project{" +
                "uuid=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", dueDate=" + dueDate +
                ", employees=" + employees +
                ", tasks=" + tasks +
                '}';
    }
}
