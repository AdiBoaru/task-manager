package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
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

    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(
            name = "verification_code")
    private UUID verificationCode;
    @Column(name = "email_verified")
    private boolean isEmailVerified;
    private boolean enabled = false;


    public Account() {
    }


    public Account(String email, String password, LocalDate createdDate) {
        this.email = email;
        this.password = password;
        this.createdDate = LocalDate.now();
    }

    public Account(String email, String password, LocalDate createdDate, UUID verificationCode, boolean isEmailVerified, boolean enabled) {
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.verificationCode = verificationCode;
        this.isEmailVerified = isEmailVerified;
        this.enabled = enabled;
    }

    public Account(String email, String password, LocalDate createdDate, Role role, UUID verificationCode, boolean isEmailVerified, boolean enabled) {
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.role = role;
        this.verificationCode = verificationCode;
        this.isEmailVerified = isEmailVerified;
        this.enabled = enabled;
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

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
