package com.example.TestMediaSoft.controller;

import com.example.TestMediaSoft.entities.personEntities.Role;
import com.example.TestMediaSoft.entities.personEntities.User;
import com.example.TestMediaSoft.repos.personRepo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This controller processes data for user editor and user page.
 */
@Controller
@RequestMapping("/user")
/**
 * Access to the controller pages will be available only to users with the admin role.
 */
@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    /**
     * Connect the repository for users to work with the database.
     */
    @Autowired
    private UserRepo userRepo;

    /**
     * This mapping handles query of show user list.
     * @param model Store received object.
     * @return userList Show list of users on user page.
     */
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userRepo.findAll());

        return "userList";
    }

    /**
     * This mapping handles form user editor.
     * @param user User entity.
     * @param model Store received object.
     * @return userEdit Show edit user data on user page.
     */
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    /**
     * This mapping saves changed user data through a form.
     * @param username Name of user.
     * @param form Processed form.
     * @param user User entity.
     * @return user Page of user.
     */
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user
    ) {
        user.setUsername(username);

        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }

        userRepo.save(user);

        return "redirect:/user";
    }
}