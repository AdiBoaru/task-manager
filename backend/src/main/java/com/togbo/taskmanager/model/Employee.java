package com.togbo.taskmanager.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.togbo.taskmanager.enums.Role;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @ManyToMany(mappedBy = "employees")
    private Set<Project> projects = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "employee_task",
            joinColumns = @JoinColumn(name = "task_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id", referencedColumnName = "id"))
    private Set<Task> tasks = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "team_id")
    @JsonIgnore
    private Team team;

    public Employee() {
    }


    public Employee(String firstName, String lastName, LocalDate birthDate, Account account) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.account = account;
    }


    private Employee(EmployeeBuilder employeeBuilder) {
        this.firstName = employeeBuilder.firstName;
        this.lastName = employeeBuilder.lastName;
        this.birthDate = employeeBuilder.birthDate;
        this.account = employeeBuilder.account;
        this.projects = employeeBuilder.projects;
        this.tasks = employeeBuilder.tasks;
        this.team = employeeBuilder.team;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", account=" + account +
                '}';
    }

    private static class EmployeeBuilder {
        //required fields
        private String firstName;
        private String lastName;
        private LocalDate birthDate;
        private Account account;

        //optional fields
        private Set<Project> projects = new HashSet<>();
        private Set<Task> tasks = new HashSet<>();
        private Team team;


        public EmployeeBuilder(String firstName, String lastName, LocalDate birthDate, Account account) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
            this.account = account;
        }

        public void setProjects(Set<Project> projects) {
            this.projects = projects;
        }

        public void setTasks(Set<Task> tasks) {
            this.tasks = tasks;
        }

        public void setTeam(Team team) {
            this.team = team;
        }

        public Employee build() {
            return new Employee(this);
        }
    }
}
