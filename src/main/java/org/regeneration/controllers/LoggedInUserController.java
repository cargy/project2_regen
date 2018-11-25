package org.regeneration.controllers;

import org.regeneration.models.User;
import org.regeneration.repositories.UserRepository;
import org.regeneration.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoggedInUserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/user")
    public Role userRole(Principal principal){
        User loggedInUser = userRepository.findByUsername(principal.getName());
        return loggedInUser.getRole();
    }

}
