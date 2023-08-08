package com.example.api.Controller;

import com.example.api.Model.Unit;
import com.example.api.Repository.unitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class RegisterController {
    @Autowired
    private unitRepository unitRepository;
    @PostMapping("/register")
    public boolean newUnit(@RequestBody Unit unit){
        unitRepository.save(unit);
        return true;
    }
}
