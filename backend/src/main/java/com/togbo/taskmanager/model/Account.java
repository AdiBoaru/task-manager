package com.togbo.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account {
    /*
    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    private UUID uuid;
*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email
    @NotBlank
    private String email;
    private String password;
    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(
            name = "verification_code")
    private UUID verificationCode;
    @Column(name = "email_verified")
    private Boolean isEmailVerified;
    public Account() {
    }


    public Account(String email, String password, UUID verificationCode) {
        this.email = email;
        this.password = password;
        this.createdDate = LocalDate.now();
        this.verificationCode = verificationCode;
        this.isEmailVerified = false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

  /*  public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

*/

    public UUID getVerificationCode() {
        return verificationCode;
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
