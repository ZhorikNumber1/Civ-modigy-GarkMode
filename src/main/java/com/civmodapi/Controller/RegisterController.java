package com.civmodapi.Controller;

import com.civmodapi.Repository.unitsRepository;
import com.civmodapi.Model.Units_civilian;
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
