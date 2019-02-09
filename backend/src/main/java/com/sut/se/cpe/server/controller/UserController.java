package com.sut.se.cpe.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sut.se.cpe.server.entity.User;
import com.sut.se.cpe.server.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class UserController {
    @Autowired
    public UserRepository userRepository;

    @GetMapping("/loging/{username}/{passwordd}")
    public Boolean getUser(@PathVariable String username, @PathVariable String passwordd){
        User usernames = userRepository.findByUsername(username);
        User passwordds = userRepository.findByPasswordd(passwordd);
        System.out.println("This is check User ==> " + username + " | " + passwordd);
        if(usernames != null && passwordds != null){
            return true;
        }
        return false;
    }
}
