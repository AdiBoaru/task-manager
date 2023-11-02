package main.java.com.togbo.taskmanager.dto;

import main.java.com.togbo.taskmanager.model.Account;
import main.java.com.togbo.taskmanager.model.Project;
import main.java.com.togbo.taskmanager.model.Task;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class EmployeeDto {
    private UUID id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private Account account;
    private Set<Task> task;
    private Set<Project> project;

    public EmployeeDto(UUID id, String firstName, String lastName, LocalDate birthDate, Account account, Set<Task> task, Set<Project> project) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.account = account;
        this.task = task;
        this.project = project;
    }

    public EmployeeDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<Task> getTask() {
        return task;
    }

    public void setTask(Set<Task> task) {
        this.task = task;
    }

    public Set<Project> getProject() {
        return project;
    }

    public void setProject(Set<Project> project) {
        this.project = project;
    }
}
