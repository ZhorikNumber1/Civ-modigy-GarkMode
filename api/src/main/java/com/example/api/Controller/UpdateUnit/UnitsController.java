package com.example.api.Controller.UpdateUnit;

import com.example.api.Model.Units;
import com.example.api.Repository.unitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UnitsController {
    @Autowired
    private unitsRepository unitsRepository;
    @GetMapping("/Unit")
    public List<Units> getAllUnits(){
        return unitsRepository.findAll();
    }
    @GetMapping(value = "/Unit/{id}")
    public Optional<Units> getUnit(@PathVariable("id") long id) {
        return unitsRepository.findById(id);
    }


}
