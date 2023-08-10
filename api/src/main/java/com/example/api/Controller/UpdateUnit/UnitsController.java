package com.example.api.Controller.UpdateUnit;

import com.example.api.Model.UnitsDto;
import com.example.api.Model.Units;
import com.example.api.Repository.unitsRepository;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class UnitsController {
    private static final String PHOTO_DIRECTORY = "E:\\Simple-CRUD-java-app\\api\\src\\main\\java\\com\\example\\api\\Img";
    @Autowired
    private unitsRepository unitsRepository;

    @GetMapping("/Unit")
    public List<UnitsDto> getAllUnits() {
        List<Units> units = unitsRepository.findAll();
        List<UnitsDto> unitsDtoList = new ArrayList<>();
        for (Units unit : units) {
            UnitsDto dto = new UnitsDto(unit.getName(), unit.getNamePhoto());
            unitsDtoList.add(dto);
        }
        return unitsDtoList;
    }

    @GetMapping(value = "/Unit/{id}")
    public UnitsDto getUnit(@PathVariable("id") long id) throws ChangeSetPersister.NotFoundException {
        Units unit = unitsRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new);

        return new UnitsDto(unit.getName(), unit.getNamePhoto());
    }

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
