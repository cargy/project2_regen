package org.regeneration.controllers;

import org.regeneration.models.Appointment;
import org.regeneration.repositories.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AppointmentController {

    private final AppointmentRepository appointmentRepository;

    @Autowired
    public AppointmentController(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    @GetMapping("/api/doctor/appointments")
    public List<Appointment> getAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                             @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                             @RequestParam(value = "search", defaultValue = "") String search) {

        List<Appointment> appointments = appointmentRepository.findAll();//new ArrayList();
        List<Appointment> response = new ArrayList<>();

        if (fromDate.equals("")) {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String now = format.format(ldt);

            fromDate = now;
        }


        if (toDate.equals("")) {
            //from+1 month
            LocalDateTime ldt = LocalDateTime.now().plusMonths(1L);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String nowPlusOneMonth = formatter.format(ldt);

            toDate = nowPlusOneMonth;
        }


        if (search.equals("")) {
            for (Appointment a : appointments) {
                if (a.getDate().compareTo(fromDate) > 0 && a.getDate().compareTo(toDate) < 0) {
                    response.add(a);
                }
            }
        } else {
            for (Appointment a : appointments) {
                if (a.getDate().compareTo(fromDate) > 0 && a.getDate().compareTo(toDate) < 0) {
                    if (a.getIllnessHistory().toLowerCase().contains(search.toLowerCase())) {
                        response.add(a);
                    }
                }
            }
        }

        return response;

    }

}

