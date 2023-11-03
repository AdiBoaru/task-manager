package main.java.com.togbo.taskmanager.model;

import jakarta.persistence.*;
import main.java.com.togbo.taskmanager.enums.Role;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private String username;
    private String password;
    @Column(name = "created_date")
    private LocalDate createdDate;
    private Role role;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Account(UUID id, String username, String password, LocalDate createdDate, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createdDate = createdDate;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                ", role=" + role +
                '}';
    }
}
