package org.regeneration.team4.project2.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {

    private Long appointmentId;
    private String date;
    private String time;
    private String illnessHistory;
    private String notes;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    private Doctor doctor_id;

    @ManyToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "citizen_id")
    private Citizen citizen_id;

    public Appointment() {
    }

    public Appointment(Long appointmentId, String date, String time, String illnessHistory, String notes, Doctor doctor_id, Citizen citizen_id) {
        this.appointmentId = appointmentId;
        this.date = date;
        this.time = time;
        this.illnessHistory = illnessHistory;
        this.notes = notes;
        this.doctor_id = doctor_id;
        this.citizen_id = citizen_id;
    }

    public Long getId() {
        return appointmentId;
    }

    public void setId(Long id) {
        this.appointmentId = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIllnessHistory() {
        return illnessHistory;
    }

    public void setIllnessHistory(String illnessHistory) {
        this.illnessHistory = illnessHistory;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Doctor getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Doctor doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Citizen getCitizen_id() {
        return citizen_id;
    }

    public void setCitizen_id(Citizen citizen_id) {
        this.citizen_id = citizen_id;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + appointmentId +
                ", appointment date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", illness history='" + illnessHistory + '\'' +
                ", notes='" + notes + '\'' +
                ", citizen id='" + citizen_id + '\'' +
                ", doctor id='" + doctor_id + '\'' +
                '}';
    }
}