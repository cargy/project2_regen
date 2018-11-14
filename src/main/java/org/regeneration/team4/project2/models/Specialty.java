package org.regeneration.team4.project2.models;

import javax.persistence.Entity;

@Entity
public class Specialty {

    Long specialtyId;
    String specialty;

    public Specialty(Long specialtyId, String specialty) {
        this.specialtyId = specialtyId;
        this.specialty = specialty;
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
}
