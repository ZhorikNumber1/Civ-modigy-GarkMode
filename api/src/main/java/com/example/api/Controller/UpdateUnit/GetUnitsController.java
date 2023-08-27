package com.example.api.Controller.UpdateUnit;

import com.example.api.Model.UnitsDTO.UnitsDTO;
import com.example.api.Model.Units_civilian;
import com.example.api.Model.UnitsDTO.Units_cvilianDto;
import com.example.api.Repository.unitsRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class GetUnitsController {
    private static final String PHOTO_DIRECTORY = "E:\\Simple-CRUD-java-app\\api\\src\\main\\java\\com\\example\\api\\Img\\";
    @Autowired
    private unitsRepository unitsRepository;

    @GetMapping("/units")
    public List<UnitsDTO> getData() throws IOException {
        List<Units_civilian> units = unitsRepository.findAll();
        List<UnitsDTO> unitsCvilianDtoList = new ArrayList<>();
        for (Units_civilian unit : units) {
            File imageFile = new File(PHOTO_DIRECTORY + unit.getNamePhoto());
            byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
            UnitsDTO dto = new UnitsDTO(unit.getName(), urlPhoto, unit.getUnitType());
            unitsCvilianDtoList.add(dto);
        }
        return unitsCvilianDtoList;
    }

    @GetMapping("/units/{name}")
    public Units_cvilianDto getUnitsbyname(@PathVariable String name) throws IOException {
        Units_civilian units;
        units = unitsRepository.findByName(name);
        File imageFile = new File(PHOTO_DIRECTORY + units.getNamePhoto());
        byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
        Units_cvilianDto dto = new Units_cvilianDto(units.getName(), units.getBaseMoves(), units.getCost(), units.getMaintenance(), urlPhoto, units.getPrereqTech(), units.getCombat(), units.getId(), units.getUnitType());
        return dto;
    }

    @GetMapping("/{photoName}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String photoName) throws IOException {
        Path photoPath = Paths.get(PHOTO_DIRECTORY).resolve(photoName);
        Resource resource = new UrlResource(photoPath.toUri());

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
