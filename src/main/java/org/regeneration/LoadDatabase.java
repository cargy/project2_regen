package org.regeneration;

import org.regeneration.models.*;
import org.regeneration.repositories.*;
import org.regeneration.security.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

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
            //Folding users (Role=Doctor)
            User userDoc1 = new User("doc1", passwordEncoder.encode("doc1password"), Role.DOCTOR);
            User userDoc2 = new User("doc2", passwordEncoder.encode("doc2password"), Role.DOCTOR);
            User userDoc3 = new User("doc3", passwordEncoder.encode("doc3password"), Role.DOCTOR);
            User userDoc4 = new User("doc4", passwordEncoder.encode("doc4password"), Role.DOCTOR);
            User userDoc5 = new User("doc5", passwordEncoder.encode("doc5password"), Role.DOCTOR);
            User userDoc6 = new User("doc6", passwordEncoder.encode("doc6password"), Role.DOCTOR);
            User userDoc7 = new User("doc7", passwordEncoder.encode("doc7password"), Role.DOCTOR);
            User userDoc8 = new User("doc8", passwordEncoder.encode("doc8password"), Role.DOCTOR);
            User userDoc9 = new User("doc9", passwordEncoder.encode("doc9password"), Role.DOCTOR);
            User userDoc10 = new User("doc10", passwordEncoder.encode("doc10password"), Role.DOCTOR);
            User userDoc11 = new User("doc11", passwordEncoder.encode("doc11password"), Role.DOCTOR);
            User userDoc12 = new User("doc12", passwordEncoder.encode("doc12password"), Role.DOCTOR);
            User userDoc13 = new User("doc13", passwordEncoder.encode("doc13password"), Role.DOCTOR);
            User userDoc14 = new User("doc14", passwordEncoder.encode("doc14password"), Role.DOCTOR);
            User userDoc15 = new User("doc15", passwordEncoder.encode("doc15password"), Role.DOCTOR);
            User userDoc16 = new User("doc16", passwordEncoder.encode("doc16password"), Role.DOCTOR);
            User userDoc17 = new User("doc17", passwordEncoder.encode("doc17password"), Role.DOCTOR);
            User userDoc18 = new User("doc18", passwordEncoder.encode("doc18password"), Role.DOCTOR);
            User userDoc19 = new User("doc19", passwordEncoder.encode("doc19password"), Role.DOCTOR);
            User userDoc20 = new User("doc20", passwordEncoder.encode("doc20password"), Role.DOCTOR);

            //Folding users (Role=Citizen)
            User userCit1 = new User("cit1", passwordEncoder.encode("cit1password"), Role.CITIZEN);
            User userCit2 = new User("cit2", passwordEncoder.encode("cit2password"), Role.CITIZEN);
            User userCit3 = new User("cit3", passwordEncoder.encode("cit3password"), Role.CITIZEN);
            User userCit4 = new User("cit4", passwordEncoder.encode("cit4password"), Role.CITIZEN);
            User userCit5 = new User("cit5", passwordEncoder.encode("cit5password"), Role.CITIZEN);
            User userCit6 = new User("cit6", passwordEncoder.encode("cit6password"), Role.CITIZEN);
            User userCit7 = new User("cit7", passwordEncoder.encode("cit7password"), Role.CITIZEN);
            User userCit8 = new User("cit8", passwordEncoder.encode("cit8password"), Role.CITIZEN);
            User userCit9 = new User("cit9", passwordEncoder.encode("cit9password"), Role.CITIZEN);
            User userCit10 = new User("cit10", passwordEncoder.encode("cit10password"), Role.CITIZEN);

            //Folding Specialties
            Specialty specialty1 = new Specialty("Cardiologist");
            Specialty specialty2 = new Specialty("Neurologist");
            Specialty specialty3 = new Specialty("Dentist");
            Specialty specialty4 = new Specialty("Surgent");
            Specialty specialty5 = new Specialty("Pediatrician");
            Specialty specialty6 = new Specialty("Ophthalmologist");
            Specialty specialty7 = new Specialty("Dermatology");
            Specialty specialty8 = new Specialty("Anesthesiology");
            Specialty specialty9 = new Specialty("Otolaryngologist");
            Specialty specialty10 = new Specialty("Oncologist");

            //Folding Doctors
            Doctor doctor1 = new Doctor("Kostas", "Petrou", "6971233698", userDoc1, specialty1);
            Doctor doctor2 = new Doctor("Anna", "Moustogianni", "6963798822", userDoc2, specialty2);
            Doctor doctor3 = new Doctor("Katerina", "Maggona", "6963976501", userDoc3, specialty3);
            Doctor doctor4 = new Doctor("Achilleas", "Rousis", "6971233692", userDoc4, specialty4);
            Doctor doctor5 = new Doctor("Ioannis", "Nikolaidis", "6963791223", userDoc5, specialty5);
            Doctor doctor6 = new Doctor("Vasilis", "Giannakidis", "6963976504", userDoc6, specialty6);
            Doctor doctor7 = new Doctor("Vasiliki", "Loustropoulou", "6971233695", userDoc7, specialty7);
            Doctor doctor8 = new Doctor("Konstantina", "Kaffe", "6963791226", userDoc8, specialty8);
            Doctor doctor9 = new Doctor("Chara", "Sarianidou", "6963976507", userDoc9, specialty9);
            Doctor doctor10 = new Doctor("Charalampos", "Ioannidis", "6963976508", userDoc10, specialty10);
            Doctor doctor11 = new Doctor("Dimitris", "Apostolou", "6971233699", userDoc11, specialty1);
            Doctor doctor12 = new Doctor("Panagiotis", "Loukas", "6963791210", userDoc12, specialty2);
            Doctor doctor13 = new Doctor("Dimitris", "Papas", "6963976511", userDoc13, specialty3);
            Doctor doctor14 = new Doctor("Stathis", "Theodorou", "6971233128", userDoc14, specialty4);
            Doctor doctor15 = new Doctor("Anastasios", "Kiliriotis", "6963791325", userDoc15, specialty5);
            Doctor doctor16 = new Doctor("Anna", "Vasilopoulou", "6963976614", userDoc16, specialty6);
            Doctor doctor17 = new Doctor("Georgios", "Georgiou", "6971233615", userDoc17, specialty7);
            Doctor doctor18 = new Doctor("Maria", "Kasaraki", "6963791216", userDoc18, specialty8);
            Doctor doctor19 = new Doctor("Nikoleta", "Perperidou", "6963976017", userDoc19, specialty9);
            Doctor doctor20 = new Doctor("Nikolaos", "Kolothas", "6963976518", userDoc20, specialty10);

            //Folding Citizens
            Citizen citizen1 = new Citizen("Vaggelis", "Giazitzidis", "vaggelisgiazitz@gmail.com", "6978986578", "12345678912", userCit1);
            Citizen citizen2 = new Citizen("Vasiliki", "Georgiou", "vasilikigeor@gmail.com", "6978912569", "98765432101", userCit2);
            Citizen citizen3 = new Citizen("Maria", "Konstantinou", "mariakon@gmail.com", "6983035874", "11223345678", userCit3);
            Citizen citizen4 = new Citizen("Ioannis", "Tryfonopoulos", "ioannistryf@gmail.com", "6973625147", "65478965412", userCit4);
            Citizen citizen5 = new Citizen("Georgios", "Vasilakis", "vasilakis@gmail.com", "6996598754", "36985214785", userCit5);
            Citizen citizen6 = new Citizen("Vasilis", "Gemistos", "gemistbill@gmail.com", "6945533698", "65478932145", userCit6);
            Citizen citizen7 = new Citizen("Christos", "Argyriadis", "cargy@gmail.com", "6936958755", "15926348715", userCit7);
            Citizen citizen8 = new Citizen("Klearchos", "Papadopoulos", "klearchos@gmail.com", "6931245332", "14275386912", userCit8);
            Citizen citizen9 = new Citizen("Patroklos", "Vasiliadis", "pat@gmail.com", "6976101955", "36985600122", userCit9);
            Citizen citizen10 = new Citizen("Georgios", "Tzinos", "tzinos@gmail.com", "6981254788", "03968574452", userCit10);

//            Appointment appointment1 = new Appointment("2018-11-25", "12:30", "Miniskos", "pairnw xapia");
//            Appointment appointment2 = new Appointment("2018-11-29", "13:30", "Vimatodotis", "");
//            Appointment appointment3 = new Appointment("2019-02-20", "18:00", "Eimai ypertasikos", "pairnw xapia");


            logger.info("Preloading " + specialtyRepository.save(specialty1));
            logger.info("Preloading " + specialtyRepository.save(specialty2));
            logger.info("Preloading " + specialtyRepository.save(specialty3));
            logger.info("Preloading " + specialtyRepository.save(specialty4));
            logger.info("Preloading " + specialtyRepository.save(specialty5));
            logger.info("Preloading " + specialtyRepository.save(specialty6));
            logger.info("Preloading " + specialtyRepository.save(specialty7));
            logger.info("Preloading " + specialtyRepository.save(specialty8));
            logger.info("Preloading " + specialtyRepository.save(specialty9));
            logger.info("Preloading " + specialtyRepository.save(specialty10));

            logger.info("Preloading " + doctorRepository.save(doctor1));
            logger.info("Preloading " + doctorRepository.save(doctor2));
            logger.info("Preloading " + doctorRepository.save(doctor3));
            logger.info("Preloading " + doctorRepository.save(doctor4));
            logger.info("Preloading " + doctorRepository.save(doctor5));
            logger.info("Preloading " + doctorRepository.save(doctor6));
            logger.info("Preloading " + doctorRepository.save(doctor7));
            logger.info("Preloading " + doctorRepository.save(doctor8));
            logger.info("Preloading " + doctorRepository.save(doctor9));
            logger.info("Preloading " + doctorRepository.save(doctor10));
            logger.info("Preloading " + doctorRepository.save(doctor11));
            logger.info("Preloading " + doctorRepository.save(doctor12));
            logger.info("Preloading " + doctorRepository.save(doctor13));
            logger.info("Preloading " + doctorRepository.save(doctor14));
            logger.info("Preloading " + doctorRepository.save(doctor15));
            logger.info("Preloading " + doctorRepository.save(doctor16));
            logger.info("Preloading " + doctorRepository.save(doctor17));
            logger.info("Preloading " + doctorRepository.save(doctor18));
            logger.info("Preloading " + doctorRepository.save(doctor19));
            logger.info("Preloading " + doctorRepository.save(doctor20));

            logger.info("Preloading " + citizenRepository.save(citizen1));
            logger.info("Preloading " + citizenRepository.save(citizen2));
            logger.info("Preloading " + citizenRepository.save(citizen3));
            logger.info("Preloading " + citizenRepository.save(citizen4));
            logger.info("Preloading " + citizenRepository.save(citizen5));
            logger.info("Preloading " + citizenRepository.save(citizen6));
            logger.info("Preloading " + citizenRepository.save(citizen7));
            logger.info("Preloading " + citizenRepository.save(citizen8));
            logger.info("Preloading " + citizenRepository.save(citizen9));
            logger.info("Preloading " + citizenRepository.save(citizen10));

//            logger.info("Preloading " + appointmentRepository.save(appointment1));
//            logger.info("Preloading " + appointmentRepository.save(appointment2));
//            logger.info("Preloading " + appointmentRepository.save(appointment3));


        };
    }
}
