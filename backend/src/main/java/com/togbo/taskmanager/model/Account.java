package com.togbo.taskmanager.model;

import com.togbo.taskmanager.enums.Role;
import com.togbo.taskmanager.model.token.Token;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "accounts")
public class Account implements UserDetails {
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
    @Column(name = "verification_code")
    private UUID verificationCode;
    @Column(name = "email_verified")
    private Boolean isEmailVerified;

    @OneToMany(mappedBy = "account")
    private List<Token> tokens;
    public Account() {
    }

    public Account(String email, String password, LocalDate createdDate, Role role, UUID verificationCode, Boolean isEmailVerified) {
        this.email = email;
        this.password = password;
        this.createdDate = createdDate;
        this.role = role;
        this.verificationCode = verificationCode;
        this.isEmailVerified = isEmailVerified;
    }

    public Account(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.createdDate = LocalDate.now();
        this.isEmailVerified = false;
    }

    /**todo
     * fix parameter of simplegrantedauthorirty
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Role.TEAM_LEAD.name()));
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

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
