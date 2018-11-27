package org.regeneration.controllers;

import org.regeneration.models.Appointment;
import org.regeneration.models.Citizen;
import org.regeneration.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    DoctorService doctorServise;

    @GetMapping("/api/doctor/appointments")
    public List<Appointment> getAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                             @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                             @RequestParam(value = "search", defaultValue = "") String search,
                                             Principal principal) {

        return doctorServise.getAppointments(fromDate,toDate,search,principal);
    }

    @GetMapping("/api/doctor/appointment/{id}")
    public Appointment doctorGetAppointment(@PathVariable Long id) {
        return doctorServise.doctorGetAppointment(id);

    }

    @GetMapping("/api/doctor/citizen/{id}")
    public Citizen getCitizen(@PathVariable Long id) {
        return doctorServise.getCitizen(id);

    }

}