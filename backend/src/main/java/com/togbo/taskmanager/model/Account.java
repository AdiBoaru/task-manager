package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.token.Token;
import javax.persistence.*;
import javax.validation.constraints.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @Column(name = "created_date")
    private LocalDate createdDate;
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "verification_code")
    private UUID verificationCode;
    @Column(name = "email_verified")
    private Boolean isEmailVerified;

    @OneToMany(mappedBy = "account")
    private List<Token> tokens;

    public Account() {
    }

    public Account(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdDate = LocalDate.now();
        this.isEmailVerified = false;
    }

    /**
     * todo
     * fix parameter of simplegrantedauthorirty
     *
     * @return
     */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Boolean getEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        isEmailVerified = emailVerified;
    }

    public void setVerificationCode(UUID verificationCode) {
        this.verificationCode = verificationCode;
    }

    public boolean isEmailVerified() {
        return isEmailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.isEmailVerified = emailVerified;
    }

    public UUID getVerificationCode() {
        return verificationCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }
}
