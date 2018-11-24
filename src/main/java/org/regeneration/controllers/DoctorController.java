package org.regeneration.controllers;

import org.regeneration.models.Doctor;
import org.regeneration.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class DoctorController {

    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @GetMapping("/api/doctors/{id}")
    public Optional<Doctor> getDoctor(@PathVariable Long id) {
        return doctorRepository.findById(id);
    }

}