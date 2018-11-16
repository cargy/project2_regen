package org.regeneration.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Doctor.
 */
@Entity
@Table(name = "doctor")
public class Doctor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long DoctorId;

    @NotNull
    @Size(max = 50)
    @Column(name = "firstname", length = 50, nullable = false)
    private String firstname;

    @NotNull
    @Size(max = 50)
    @Column(name = "lastname", length = 50, nullable = false)
    private String lastname;

    @NotNull
    @Size(max = 10)
    @Column(name = "phone", length = 10, nullable = false, unique = true)
    private String phone;

    @ManyToOne(cascade=CascadeType.DETACH)
    @JsonIgnoreProperties("doctors")
    private Specialty specialty;

    @OneToOne
    @JoinColumn(unique = true)
    private User user;

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointments = new HashSet<>();

    public Doctor() {
    }

    public Doctor(@NotNull @Size(max = 50) String firstname, @NotNull @Size(max = 50) String lastname, @NotNull @Size(max = 10) String phone) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
    }

    public Doctor(@NotNull @Size(max = 50) String firstname, @NotNull @Size(max = 50) String lastname, @NotNull @Size(max = 10) String phone, Specialty specialty, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.specialty = specialty;
        this.user = user;
    }

    public Doctor(@NotNull @Size(max = 50) String firstname, @NotNull @Size(max = 50) String lastname, @NotNull @Size(max = 10) String phone, User user) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.user = user;
    }

    public Doctor(@NotNull @Size(max = 50) String firstname, @NotNull @Size(max = 50) String lastname, @NotNull @Size(max = 10) String phone, Specialty specialty, User user, Set<Appointment> appointments) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.specialty = specialty;
        this.user = user;
        this.appointments = appointments;
    }

    public Long getDoctorId() {
        return DoctorId;
    }

    public void setDoctorId(Long doctorId) {
        DoctorId = doctorId;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
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
