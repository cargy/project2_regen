package org.regeneration.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A Appointment.
 */
@Entity
@Table(name = "appointment")
public class Appointment implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long appointmentId;

    @NotNull
    @Size(max = 50)
    @Column(name = "date", length = 50, nullable = false)
    private String date;

    @NotNull
    @Size(max = 50)
    @Column(name = "time", length = 50, nullable = false)
    private String time;

    @Column(name = "illness_history")
    private String illnessHistory;

    @Column(name = "notes")
    private String notes;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "citizen_id")
    private Citizen citizen;

    public Appointment(@NotNull @Size(max = 50) String date, @NotNull @Size(max = 50) String time, String illnessHistory, String notes, Doctor doctor, Citizen citizen) {
        this.date = date;
        this.time = time;
        this.illnessHistory = illnessHistory;
        this.notes = notes;
        this.doctor = doctor;
        this.citizen = citizen;
    }

    public Appointment(@NotNull @Size(max = 50) String date, @NotNull @Size(max = 50) String time, String illnessHistory, String notes) {
        this.date = date;
        this.time = time;
        this.illnessHistory = illnessHistory;
        this.notes = notes;
    }

    public Appointment() {
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
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
