package org.regeneration.controllers;

import org.regeneration.dto.EditAppointmentDTO;
import org.regeneration.dto.NewAppointmentDTO;
import org.regeneration.exceptions.*;
import org.regeneration.models.*;
import org.regeneration.repositories.*;
import org.regeneration.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    UserRepository userRepository;


    @PostMapping("/api/citizen/appointment")
    public Appointment createCitizenAppointment(@RequestBody NewAppointmentDTO newAppointmentDTO, Principal principal) {
        Appointment appointment = new Appointment();
        User loggedInUser = userRepository.findByUsername(principal.getName());
        if (loggedInUser.getRole() == Role.CITIZEN) {
            Citizen citizen = loggedInUser.getCitizen();

            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String now = format.format(ldt);

            if(newAppointmentDTO.getDate().compareTo(now)<0){
                throw new AppointmentInPastException();

            }


            Doctor doctor = doctorRepository.findById(newAppointmentDTO.getDoctorId()).get();
            for (Appointment doctorAppointment : doctor.getAppointments()) {
                if (doctorAppointment.getDate().equals(newAppointmentDTO.getDate()) && doctorAppointment.getTime().equals((newAppointmentDTO.getTime()))) {
                    throw new DoctorAppointmentConflictException();
                }
            }
            for (Appointment citizenAppointment : citizen.getAppointments()) {
                if (citizenAppointment.getDate().equals(newAppointmentDTO.getDate()) && citizenAppointment.getTime().equals((newAppointmentDTO.getTime()))) {
                    throw new CitizenAppointmentConflictException();
                }
            }
            appointment.setCitizen(citizen);
            appointment.setDoctor(doctor);
            appointment.setDate(newAppointmentDTO.getDate());
            appointment.setTime(newAppointmentDTO.getTime());
            appointment.setIllnessHistory(newAppointmentDTO.getIllnessHistory());
            appointment.setNotes(newAppointmentDTO.getNotes());
            appointment = appointmentRepository.save(appointment);
            return appointment;
        }
        return null;
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

    @PutMapping("/api/citizen/appointment")
    public Appointment editAppointment(@RequestBody EditAppointmentDTO editAppointmentDTO,
                                       Principal principal) {

        Appointment appointmentToEdit=appointmentRepository.findById(editAppointmentDTO.getAppointmentId()).get();
        Doctor doctor = doctorRepository.findById(appointmentToEdit.getDoctor().getDoctorId())
                .orElseThrow(() -> new DoctorNotFoundException(appointmentToEdit.getDoctor().getDoctorId()));

        User loggedInUser = userRepository.findByUsername(principal.getName());
        if (loggedInUser.getRole() == Role.CITIZEN) {
            Citizen citizen = loggedInUser.getCitizen();

            for (Appointment doctorsAppointment : doctor.getAppointments()) {
                if (doctorsAppointment.getAppointmentId() != appointmentToEdit.getAppointmentId()) {//apofeugw to na sygkrinw to idio rantevou
                    if (doctorsAppointment.getDate().equals(appointmentToEdit.getDate()) && doctorsAppointment.getTime().equals(appointmentToEdit.getTime())) {
                        throw new DoctorAppointmentConflictException();
                    }
                }
            }
            for (Appointment citizenAppointment : citizen.getAppointments()) {
                if (citizenAppointment.getAppointmentId() != appointmentToEdit.getAppointmentId()) {//apofeugw to na sygkrinw to idio rantevou
                    if (citizenAppointment.getDate().equals(appointmentToEdit.getDate()) && citizenAppointment.getTime().equals(appointmentToEdit.getTime())) {
                        throw new CitizenAppointmentConflictException();
                    }
                }
            }
            appointmentToEdit.setDate(editAppointmentDTO.getDate());
            appointmentToEdit.setTime(editAppointmentDTO.getTime());
            appointmentToEdit.setIllnessHistory(editAppointmentDTO.getIllnessHistory());
            appointmentToEdit.setNotes(editAppointmentDTO.getNotes());

            appointmentRepository.save(appointmentToEdit);
            return appointmentToEdit;
        }
        return null;
    }
}