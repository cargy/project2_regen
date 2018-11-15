package org.regeneration.team4.project2.models;

import javax.persistence.Entity;

@Entity
public class Account {

    Long accountId;
    String username;
    String password;

    public Account(){}

    public Account(Long accountId, String username, String password) {
        this.accountId = accountId;
        this.username = username;
        this.password = password;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
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
}
