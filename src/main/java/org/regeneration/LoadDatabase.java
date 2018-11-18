package org.regeneration;

import org.regeneration.models.*;
import org.regeneration.repositories.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.print.Doc;
import java.util.Optional;

@Configuration
public class LoadDatabase {


    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder,
                                   DoctorRepository doctorRepository,
                                   AppointmentRepository appointmentRepository,
                                   SpecialtyRepository specialtyRepository,
                                   CitizenRepository citizenRepository) {
        return args -> {
            User userGuest  = new User("user",  passwordEncoder.encode("user" ));
            User userGuest1 = new User("user1", passwordEncoder.encode("user1"));
            User userGuest2 = new User("user2", passwordEncoder.encode("user2"));
            User userGuest3 = new User("user3", passwordEncoder.encode("user3"));
            User userGuest4 = new User("user4", passwordEncoder.encode("user4"));

            Specialty specialty = new Specialty("cardiologist");
            Specialty specialty1 = new Specialty("neurologist");
            Specialty specialty2 = new Specialty("biologist");

            Doctor doctor = new Doctor("kostos", "petrou", "697123", userGuest, specialty);
            Doctor doctor1 = new Doctor("anna", "petridou", "696379", userGuest1, specialty1);
            Doctor doctor2 = new Doctor("anna", "petridou", "69639765", userGuest3, specialty);

            Citizen citizen= new Citizen("vaggeli", "kontino","rty@gmail.com","678986578","12345678912", userGuest2);

            Appointment appointment= new Appointment("2018-11-25","12:30","kardia","pairnw xapia");
            Appointment appointment1= new Appointment("2018-11-25","13:30","kardia kai pneumonia","pairnw");

//            specialty.getDoctors().add(doctor);
//            specialty.getDoctors().add(doctor1);
//            specialty1.getDoctors().add(doctor2);
//
//            doctor.setSpecialty(specialty);
//            doctor1.setSpecialty(specialty);
//            doctor2.setSpecialty(specialty1);
//
//            citizen.getAppointments().add(appointment);
//            citizen.getAppointments().add(appointment1);
//
//            doctor.getAppointments().add(appointment);
//            doctor1.getAppointments().add(appointment1);
//
//            appointment.setCitizen(citizen);
//            appointment.setDoctor(doctor);
//
//            appointment1.setCitizen(citizen);
//            appointment1.setDoctor(doctor1);


//            logger.info("Preloading " + userRepository.save(userGuest));
//            logger.info("Preloading " + userRepository.save(userGuest1));
//            logger.info("Preloading " + userRepository.save(userGuest2));
//            logger.info("Preloading " + userRepository.save(userGuest3));

            logger.info("Preloading " + specialtyRepository.save(specialty));
            logger.info("Preloading " + specialtyRepository.save(specialty1));
            logger.info("Preloading " + specialtyRepository.save(specialty2));

            logger.info("Preloading " + doctorRepository.save(doctor));
            logger.info("Preloading " + doctorRepository.save(doctor1));
            logger.info("Preloading " + doctorRepository.save(doctor2));
//
//            logger.info("Preloading " + citizenRepository.save(citizen));
//
//            logger.info("Preloading " + appointmentRepository.save(appointment));
//            logger.info("Preloading " + appointmentRepository.save(appointment1));


            Optional<Doctor> d = doctorRepository.findById(4L);

            doctorRepository.delete(d.get());
//            doctorRepository.deleteAll();
//            appointmentRepository.delete(appointment);
//            specialtyRepository.delete(specialty);

        };
    }
}
