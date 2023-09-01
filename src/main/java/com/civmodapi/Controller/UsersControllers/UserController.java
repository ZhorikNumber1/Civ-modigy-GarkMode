package com.civmodapi.Controller.UsersControllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/1")
    public String helloUserController(){
        return "User access level";
    }
    
}
