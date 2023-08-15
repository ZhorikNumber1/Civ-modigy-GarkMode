package com.example.api.Controller.UpdateUnit;

import com.example.api.Model.UnitsDTO.Units_cvilianDto;
import com.example.api.Model.Units_civilian;
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
    public List<Units_cvilianDto> getData() throws IOException {
        List<Units_civilian> units = unitsRepository.findAll();
        List<Units_cvilianDto> unitsCvilianDtoList = new ArrayList<>();
        for (Units_civilian unit : units) {
            File imageFile = new File(PHOTO_DIRECTORY+unit.getNamePhoto());
            byte[] urlPhoto = Files.readAllBytes(imageFile.toPath());
            //Units_cvilianDto dto = new Units_cvilianDto(unit.getName(), unit.getNamePhoto(), urlPhoto);
            //unitsCvilianDtoList.add(dto);
        }
        return unitsCvilianDtoList;
    }

 /* @GetMapping(value = "/Unit/{id}")
    public UnitsDto getUnit(@PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        Units unit = unitsRepository.findById(id);

        return new UnitsDto(unit.getName(), unit.getNamePhoto());
    }*/
    @GetMapping("/{photoName}")
    public ResponseEntity<Resource> getPhoto(@PathVariable String photoName) throws IOException {
        Path photoPath = Paths.get(PHOTO_DIRECTORY).resolve(photoName);
        Resource resource = new UrlResource(photoPath.toUri());

        if (resource.exists()) {
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG) // или MediaType.IMAGE_PNG в зависимости от типа изображения
                    .body(resource);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
