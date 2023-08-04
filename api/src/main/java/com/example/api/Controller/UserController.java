package com.example.api.Controller;

import com.example.api.Model.User;
import com.example.api.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private userRepository UserRepository;
    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }
}
