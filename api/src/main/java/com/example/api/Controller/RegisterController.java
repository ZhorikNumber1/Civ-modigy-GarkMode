package com.example.api.Controller;

import com.example.api.Model.User;
import com.example.api.Repository.userRepository;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class RegisterController {
    private userRepository UserRepository;
    @PostMapping("/register")
    public JSONPObject newUser(@RequestBody User user){
        UserRepository.save(user);

    }
}
