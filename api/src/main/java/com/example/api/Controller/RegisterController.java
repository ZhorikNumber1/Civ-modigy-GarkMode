package com.example.api.Controller;

import com.example.api.Model.Units_civilian;
import com.example.api.Repository.unitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/security")
public class RegisterController {
    @Autowired
    private unitsRepository unitsRepository;
    @PostMapping("/register")
    public boolean newUnit(@RequestBody Units_civilian unit){
        unitsRepository.save(unit);
        return true;
    }
}
