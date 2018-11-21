package org.regeneration.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Citizen.
 */
@Entity
@Table(name = "citizen")
public class Citizen implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long citizenId;

    @NotNull
    @Column(name = "firstname", nullable = false)
    private String firstname;

    @NotNull
    @Column(name = "lastname", nullable = false)
    private String lastname;

    @NotNull
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @NotNull
    @Size(max = 10)
    @Column(name = "phone", length = 10, nullable = false, unique = true)
    private String phone;

    @NotNull
    @Size(max = 11)
    @Column(name = "ssn", length = 11, nullable = false, unique = true)
    private String ssn;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference
    @OneToMany(mappedBy = "citizen", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

    public Citizen() {
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public Citizen(@NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull @Size(max = 10) String phone, @NotNull @Size(max = 11) String ssn, User user, Set<Appointment> appointments) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.ssn = ssn;
        this.user = user;
        this.appointments = appointments;
    }

    public Citizen(@NotNull String firstname, @NotNull String lastname, @NotNull String email, @NotNull @Size(max = 10) String phone, @NotNull @Size(max = 11) String ssn, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.ssn = ssn;
        this.user = user;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(Set<Appointment> appointments) {
        this.appointments = appointments;
    }
}
