package org.regeneration.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A User.
 */
@Entity
@Table(name = "user")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @NotNull
    @Size(max = 50)
    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user")
    private Doctor doctor;

    @OneToOne(mappedBy = "user")
    private Citizen citizen;

    public User() {
    }

    public User(@NotNull @Size(max = 50) String username, String password, Doctor doctor) {
        this.username = username;
        this.password = password;
        this.doctor = doctor;

    }

    public User(@NotNull @Size(max = 50) String username, String password, Citizen citizen) {
        this.username = username;
        this.password = password;
        this.citizen = citizen;
    }


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
