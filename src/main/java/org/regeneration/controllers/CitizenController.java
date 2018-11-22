package org.regeneration.controllers;

import org.regeneration.exceptions.AppointmentNotFoundException;
import org.regeneration.exceptions.DoctorWithSelectedSpecilatyNotFoundException;
import org.regeneration.exceptions.SpecialtyNotFoundException;
import org.regeneration.models.Appointment;
import org.regeneration.models.Citizen;
import org.regeneration.models.Doctor;
import org.regeneration.models.Specialty;
import org.regeneration.repositories.AppointmentRepository;
import org.regeneration.repositories.CitizenRepository;
import org.regeneration.repositories.DoctorRepository;
import org.regeneration.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Controller
//@RequestMapping("/api/citizen")
@RestController
public class CitizenController {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    CitizenRepository citizenRepository;
    @Autowired
    SpecialtyRepository specialtyRepository;

    @PostMapping("/api/citizen/appointment")
    public Appointment createCitizenAppointment(Long citizenId, Long doctorId, String date, String time, String illnessHistory, String notes) {
        Appointment appointment = new Appointment();
        Optional<Citizen> citizenOptional = citizenRepository.findById(citizenId);
        Citizen citizen = citizenOptional.get();
        appointment.setCitizen(citizen);
        Optional<Doctor> doctorOptional = doctorRepository.findById(doctorId);
        Doctor doctor = doctorOptional.get();
        appointment.setDoctor(doctor);
        appointment.setDate(date);
        appointment.setTime(time);
        appointment.setIllnessHistory(illnessHistory);
        appointment.setNotes(notes);
        appointment = appointmentRepository.save(appointment);
        return appointment;
    }

    @GetMapping("/api/citizen/specialties")
    public List<Specialty> getSpecialties() {
        return specialtyRepository.findAll();
    }

    @GetMapping("/api/citizen/doctor/{specialtyId}")
    public List<Doctor> getDoctors(@PathVariable Long specialtyId) {
        List<Doctor> doctors = new ArrayList<Doctor>();
        Optional<Specialty> specialtyOptional = specialtyRepository.findById(specialtyId);
        if (specialtyOptional.isPresent()) {
            Specialty specialty = specialtyOptional.get();
            doctors = doctorRepository.findBySpecialty(specialty);
            if (!doctors.isEmpty()) {
                return doctors;
            } else {
                throw new DoctorWithSelectedSpecilatyNotFoundException(specialty.getSpecialty());
            }
        } else {
            throw new SpecialtyNotFoundException(specialtyId);
        }
    }

    @GetMapping("/api/citizen/appointment/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new AppointmentNotFoundException(id));

    }


    @DeleteMapping("/api/citizen/appointment/{appointmentId}")
    public void deleteAppointmentById(@PathVariable Long appointmentId) {

        getAppointmentById(appointmentId);
        appointmentRepository.deleteById(appointmentId);

    }

}