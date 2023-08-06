package com.example.api.Controller;

import com.example.api.Model.User;
import com.example.api.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    @Autowired
    private userRepository UserRepository;
    @GetMapping("/Users")
    public List<User> getAllUsers(){
        return UserRepository.findAll();
    }
    @GetMapping(value = "/users/{id}")
    public Optional<User> getUser(@PathVariable("id") long id) {
        return UserRepository.findById(id);
    }
    @PostMapping("/createUser")
    public User createUser(@RequestBody User user){
        return UserRepository.save(user);
    }
    @DeleteMapping("/deleteUser/{id}")
    public Boolean deleteUser(@PathVariable(value = "id") Long id){
        UserRepository.deleteById(id);
        return true;
    }
}
