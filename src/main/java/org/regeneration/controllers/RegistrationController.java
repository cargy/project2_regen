package org.regeneration.controllers;

import org.regeneration.dto.UserRegistrationDTO;
import org.regeneration.models.Citizen;
import org.regeneration.models.User;
import org.regeneration.repositories.CitizenRepository;
import org.regeneration.repositories.UserRepository;
import org.regeneration.services.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    CitizenRepository citizenRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/registration")
    public String newRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO){

        User newUser = new User();
        newUser.setUsername(userRegistrationDTO.getUsername());
        newUser.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        newUser.setRole(userRegistrationDTO.getRole());

        Citizen newCitizen = new Citizen();
        newCitizen.setFirstname(userRegistrationDTO.getFirstname());
        newCitizen.setLastname(userRegistrationDTO.getLastname());
        newCitizen.setLastname(userRegistrationDTO.getLastname());
        newCitizen.setEmail(userRegistrationDTO.getEmail());
        newCitizen.setPhone(userRegistrationDTO.getPhone());
        newCitizen.setSsn(userRegistrationDTO.getSsn());
        newCitizen.setUser(newUser);

        //userRepository.save(newUser);
        citizenRepository.save(newCitizen);

        return "User created";
    }


}
