package com.civmodapi.Service.UnitsService;

import com.civmodapi.DTOs.UnitsCvilianDTO;
import com.civmodapi.Model.UnitsCivilian;
import com.civmodapi.Repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
@Service
public class GetSpecificUnit {
    private static final String PHOTO_DIRECTORY = "E:\\Simple-CRUD-java-app\\src\\main\\java\\com\\civmodapi\\Img\\";
    @Autowired
    public UnitsRepository unitsRepository;


    public UnitsCvilianDTO getUnit(String name) throws IOException {

        UnitsCivilian units;
        units = unitsRepository.findByName(name);

        File imageFile = new File(PHOTO_DIRECTORY + units.getNamePhoto());
        byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
        UnitsCvilianDTO specificUnit = new UnitsCvilianDTO(units.getName(), units.getBaseMoves(), units.getCost(), units.getMaintenance(), urlPhoto, units.getPrereqTech(), units.getCombat(), units.getId(), units.getUnitType());
        return specificUnit;
    }
}
