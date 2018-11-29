package org.regeneration.services;

import org.regeneration.models.User;
import org.regeneration.repositories.UserRepository;
import org.regeneration.security.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
@Service
public class LoggedInUserService {

    @Autowired
    UserRepository userRepository;

    public Role userRole(Principal principal) {
        User loggedInUser = userRepository.findByUsername(principal.getName());
        return loggedInUser.getRole();
    }
}
