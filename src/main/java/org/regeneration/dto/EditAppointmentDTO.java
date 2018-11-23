package org.regeneration.dto;

public class EditAppointmentDTO {

    private Long appointmentId;
    private Long specialtyId;
    private Long doctorId;
    private String date;
    private String time;
    private String illnessHistory;
    private String notes;

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
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

    @Override
    public String toString() {
        return "EditAppointmentDTO{" +
                "appointmentId=" + appointmentId +
                ", specialtyId=" + specialtyId +
                ", doctorId=" + doctorId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", illnessHistory='" + illnessHistory + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
