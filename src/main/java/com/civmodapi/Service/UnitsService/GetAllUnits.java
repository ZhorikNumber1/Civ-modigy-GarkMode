package com.civmodapi.Service.UnitsService;

import com.civmodapi.DTOs.UnitsDTO;
import com.civmodapi.Model.UnitsCivilian;
import com.civmodapi.Repository.UnitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class GetAllUnits {
    @Autowired
    private UnitsRepository unitsRepository;
    private static final String PHOTO_DIRECTORY = "E:\\Simple-CRUD-java-app\\src\\main\\java\\com\\civmodapi\\Img\\";
    public List<UnitsDTO> getAllUnits() throws IOException {

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
}
