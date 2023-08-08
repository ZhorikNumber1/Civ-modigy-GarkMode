package com.example.api.Controller;

import com.example.api.Model.Unit;
import com.example.api.Repository.unitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UnitController {
    @Autowired
    private unitRepository unitRepository;
    @GetMapping("/Unit")
    public List<Unit> getAllUnits(){
        return unitRepository.findAll();
    }
    @GetMapping(value = "/Unit/{id}")
    public Optional<Unit> getUnit(@PathVariable("id") long id) {
        return unitRepository.findById(id);
    }
    @PostMapping("/createUnit")
    public Unit createUnit(@RequestBody Unit unit){
        return unitRepository.save(unit);
    }
    @DeleteMapping("/deleteUnit/{id}")
    public Boolean deleteUnit(@PathVariable(value = "id") Long id){
        unitRepository.deleteById(id);
        return true;
    }
}
