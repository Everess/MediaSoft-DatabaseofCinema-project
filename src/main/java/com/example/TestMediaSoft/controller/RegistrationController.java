package com.example.TestMediaSoft.controller;

import com.example.TestMediaSoft.entities.personEntities.Role;
import com.example.TestMediaSoft.entities.personEntities.User;
import com.example.TestMediaSoft.repos.personRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

/**
 * This controller processes data for user registration.
 */
@Controller
public class RegistrationController {
    /**
     * Connect the repository for users to work with the database.
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * Mapping to indicate the registration page.
     * @return registration This page of registration.
     */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    /**
     * This mapping handles add user form.
     * @param user Entity user.
     * @param model Store received object.
     * @return login Redirect to login page.
     */
    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        User usr = userRepo.findByUsername(user.getUsername());
        if (usr != null) {
            model.put("message", "User exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
