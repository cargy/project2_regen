package org.regeneration.controllers;

import org.regeneration.dto.UserRegistrationDTO;
import org.regeneration.models.Citizen;
import org.regeneration.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;


    @PostMapping("/registration")
    public Citizen newRegistration(@RequestBody UserRegistrationDTO userRegistrationDTO) {
        return registrationService.newRegistration(userRegistrationDTO);
    }
}