package org.regeneration.controllers;

import org.regeneration.security.Role;
import org.regeneration.services.LoggedInUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoggedInUserController {

    @Autowired
    LoggedInUserService loggedInUserService;

    @GetMapping("/api/user")
    public Role userRole(Principal principal) {
        return loggedInUserService.userRole(principal);
    }

}
