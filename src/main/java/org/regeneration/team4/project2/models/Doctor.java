package org.regeneration.team4.project2.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Doctor {

    private Long doctorId;
    private String firstname;
    private String lastname;
    private String phone;
    @ManyToOne
    @JoinColumn(name="specialty_id", referencedColumnName = "specialty_id")
    private Specialty specialtyId;
    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account accountID;

    public Doctor(Long doctorId, String firstname, String lastname, String phone, Specialty specialtyId, Account accountID) {
        this.doctorId = doctorId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.specialtyId = specialtyId;
        this.accountID = accountID;
    }

    public Doctor() {}

    @Id
    @GeneratedValue
    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Specialty getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Specialty specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Account getAccountID() {
        return accountID;
    }

    public void setAccountID(Account accountID) {
        this.accountID = accountID;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + doctorId +
                ", firstname='" + firstname+ '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone number='" + phone + '\'' +
                '}';
    }

}
