package com.civmodapi.Controller.UpdateUnit;

import com.civmodapi.DTOs.UnitsDTO;
import com.civmodapi.Model.UnitsCivilian;
import com.civmodapi.DTOs.UnitsCvilianDTO;
import com.civmodapi.Repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mod")
public class GetUnitsController {
    private static final String PHOTO_DIRECTORY = "E:\\Simple-CRUD-java-app\\src\\main\\java\\com\\civmodapi\\Img\\";
    @Autowired
    private UnitsRepository unitsRepository;

    @GetMapping("/units")
    public List<UnitsDTO> getData() throws IOException {
        
        List<UnitsCivilian> units = unitsRepository.findAll();
        List<UnitsDTO> unitsCvilianDtoList = new ArrayList<>();
        
        for (UnitsCivilian unit : units) {
            
            File imageFile = new File(PHOTO_DIRECTORY + unit.getNamePhoto());
            byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
            UnitsDTO dto = new UnitsDTO(unit.getName(), urlPhoto, unit.getUnitType());
            unitsCvilianDtoList.add(dto);
        }
        return unitsCvilianDtoList;
    }

    @GetMapping("/units/{name}")
    public UnitsCvilianDTO getUnitsbyname(@PathVariable String name) throws IOException {
        
        UnitsCivilian units;
        units = unitsRepository.findByName(name);
        
        File imageFile = new File(PHOTO_DIRECTORY + units.getNamePhoto());
        byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
        UnitsCvilianDTO specificUnit = new UnitsCvilianDTO(units.getName(), units.getBaseMoves(), units.getCost(), units.getMaintenance(), urlPhoto, units.getPrereqTech(), units.getCombat(), units.getId(), units.getUnitType());
        return specificUnit;
    }
}
