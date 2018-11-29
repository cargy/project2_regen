package org.regeneration.dto;

public class EditAppointmentDTO {

    private Long appointmentId;
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
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", illnessHistory='" + illnessHistory + '\'' +
                ", notes='" + notes + '\'' +
                '}';
    }
}
