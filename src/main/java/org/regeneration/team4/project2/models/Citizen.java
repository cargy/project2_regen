package org.regeneration.team4.project2.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Citizen {

    Long citizenId;
    String ssn;
    String firstname;
    String lastname;
    String email;
    String phone;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account accountId;

    public Citizen() {
    }

    public Citizen(Long citizenId, String ssn, String firstname, String lastname, String email, String phone, Account accountId) {
        this.citizenId = citizenId;
        this.ssn = ssn;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.accountId = accountId;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "id=" + citizenId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone number='" + phone + '\'' +
                ", account='" + accountId + '\'' +
                '}';
    }


    private String username;

    public String getUsername() {
        return username;
    }

    private String password;

    public String getPassword() {
        return password;
    }
}
