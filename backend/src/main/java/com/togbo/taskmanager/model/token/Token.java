package com.togbo.taskmanager.token;

import com.togbo.taskmanager.model.Account;
import jakarta.persistence.*;

@Entity
@Table(name = "token")
public class Token {

    @Id
    @GeneratedValue
    public Long id;

    @Column(unique = true)
    public String token;

    @Enumerated(EnumType.STRING)
    public TokenType tokenType = TokenType.BEARER;

    public boolean revoked;

    public boolean expired;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    public Account account;

    public Token() {
    }

    public Token(String token, TokenType tokenType, boolean revoked, boolean expired, Account account) {
        this.token = token;
        this.tokenType = tokenType;
        this.revoked = revoked;
        this.expired = expired;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public boolean isRevoked() {
        return revoked;
    }

    public boolean isExpired() {
        return expired;
    }

    public Account getAccount() {
        return account;
    }

    public void setRevoked(boolean revoked) {
        this.revoked = revoked;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }
}