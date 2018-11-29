package org.regeneration.services;
import org.regeneration.dto.UserRegistrationDTO;
import org.regeneration.exceptions.CredentialsExistException;
import org.regeneration.models.Citizen;
import org.regeneration.models.User;
import org.regeneration.repositories.CitizenRepository;
import org.regeneration.repositories.UserRepository;
import org.regeneration.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {


    @Autowired
    CitizenRepository citizenRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Citizen newRegistration(UserRegistrationDTO userRegistrationDTO) {

        if (userRepository.findByUsername(userRegistrationDTO.getUsername()) == null
                && citizenRepository.findByEmail(userRegistrationDTO.getEmail()) == null
                && citizenRepository.findByPhone(userRegistrationDTO.getPhone()) == null
                && citizenRepository.findBySsn(userRegistrationDTO.getSsn()) == null) {

            User newUser = new User();
            newUser.setUsername(userRegistrationDTO.getUsername());
            newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
            newUser.setRole(Role.CITIZEN);

            Citizen newCitizen = new Citizen();
            newCitizen.setFirstname(userRegistrationDTO.getFirstname());
            newCitizen.setLastname(userRegistrationDTO.getLastname());
            newCitizen.setEmail(userRegistrationDTO.getEmail());
            newCitizen.setPhone(userRegistrationDTO.getPhone());
            newCitizen.setSsn(userRegistrationDTO.getSsn());
            newCitizen.setUser(newUser);

            return citizenRepository.save(newCitizen);
        } else {
            throw new CredentialsExistException(userRegistrationDTO.getUsername(), userRegistrationDTO.getEmail(), userRegistrationDTO.getPhone(), userRegistrationDTO.getSsn());
        }
    }

}

