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

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Appointment> appointments;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "specialty_id")
    private Specialty specialty;

    public Doctor() {
    }

    public Doctor(@NotNull @Size(max = 50) String firstname, @NotNull @Size(max = 50) String lastname, @NotNull @Size(max = 10) String phone, User user, Set<Appointment> appointments, Specialty specialty) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.user = user;
        this.appointments = appointments;
        this.specialty = specialty;
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

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }
}
