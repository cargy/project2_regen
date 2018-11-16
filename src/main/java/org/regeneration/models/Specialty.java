package org.regeneration.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Specialty.
 */
@Entity
@Table(name = "specialty")
public class Specialty implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long specialtyId;

    @Size(max = 50)
    @Column(name = "specialty", length = 50)
    private String specialty;

    @OneToMany(mappedBy = "specialty")
    private Set<Doctor> doctors = new HashSet<>();

    public Specialty() {
    }

    public Specialty(@Size(max = 50) String specialty) {
        this.specialty = specialty;
    }

    public Specialty(@Size(max = 50) String specialty, Set<Doctor> doctors) {
        this.specialty = specialty;
        this.doctors = doctors;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }
}
