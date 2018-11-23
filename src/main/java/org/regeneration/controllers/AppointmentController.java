package org.regeneration.controllers;

import org.regeneration.models.Appointment;
import org.regeneration.models.User;
import org.regeneration.repositories.AppointmentRepository;
import org.regeneration.repositories.UserRepository;
import org.regeneration.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;


@RestController
public class AppointmentController {

    @Autowired
    AppointmentRepository appointmentRepository;

    @Autowired
    UserRepository userRepository;


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
            //from+1 month//todo einai lathos mallon!! thelei +1 apo to fromDate
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


    @GetMapping("/api/citizen/appointments")
    public List<Appointment> getCitAppointments(@RequestParam(value = "fromDate", defaultValue = "") String fromDate,
                                                @RequestParam(value = "toDate", defaultValue = "") String toDate,
                                                @RequestParam(value = "specialty", defaultValue = "") String specialty,
                                                Principal principal) {

        User loggedInUser = userRepository.findByUsername(principal.getName());

        if (loggedInUser.getRole() == Role.CITIZEN) {

            Long citId = loggedInUser.getCitizen().getCitizenId();

            List<Appointment> appointments = appointmentRepository.findAll();
            List<Appointment> response = new ArrayList<>();

            if (fromDate.equals("")) {
                LocalDateTime ldt = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String now = format.format(ldt);

                fromDate = now;
            }


            if (toDate.equals("")) {
                //from+1 month
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

                TemporalAccessor date = formatter.parse(fromDate);
                LocalDate ldt = LocalDate.from(date).plusMonths(1L);

                String fromDatePlusOneMonth = formatter.format(ldt);

                toDate = fromDatePlusOneMonth;
            }


            if (specialty.equals("")) {
                for (Appointment a : appointments) {
                    if (a.getDate().compareTo(fromDate) > 0 && a.getDate().compareTo(toDate) < 0 && a.getCitizen().getCitizenId() == citId) {
                        response.add(a);
                    }
                }
            } else {
                for (Appointment a : appointments) {
                    if (a.getDate().compareTo(fromDate) > 0 && a.getDate().compareTo(toDate) < 0 && a.getCitizen().getCitizenId() == citId) {
                        if (a.getDoctor().getSpecialty().equals(specialty)) {
                            response.add(a);
                        }
                    }
                }
            }

            return response;
        }

        return null;

    }

}

