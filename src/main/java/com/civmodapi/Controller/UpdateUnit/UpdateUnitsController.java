package com.civmodapi.Controller.UpdateUnit;

import com.civmodapi.Model.ModsUnits;
import com.civmodapi.Model.UnitsCivilian;
import com.civmodapi.Repository.UnitsRepository;
import com.civmodapi.Repository.ModUnitsRepository;
import com.civmodapi.Service.ModTextService;
import com.civmodapi.Service.UserModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mod")
public class UpdateUnitsController {
    @Autowired
    private UnitsRepository unitsRepository;
    @Autowired
    private ModUnitsRepository mod_unitsRepository;
    @PostMapping(path = "/create_mod")
    public String create_mod(@RequestBody ModsUnits unit_Update) throws IOException {

        Optional<UnitsCivilian> exsting_Unit = unitsRepository.findById(unit_Update.getId());
        mod_unitsRepository.save(unit_Update);

        UserModService.createModFolder(unit_Update.getNameMod());
        String folderPath = "E:\\Simple-CRUD-java-app\\Mods\\" + unit_Update.getNameMod();

        UserModService.addTextToModInfoFile(ModTextService.modInfoFile_text(unit_Update), "E:\\Simple-CRUD-java-app\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getNameMod() + ".modinfo");
        UserModService.addTextToModInfoFile(ModTextService.xmlDBFile_inGameActions(unit_Update, exsting_Unit), "E:\\Simple-CRUD-java-app\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getName() + unit_Update.getNameMod() + ".xml");
        UserModService.archiveFolder(folderPath);
        String modInfoFile = ModTextService.modInfoFile_text(unit_Update);

        return unit_Update.getNameMod();
    }
    @GetMapping("/downloadMod/{nameMod}")
    public ResponseEntity<Resource> downloadMod(@PathVariable String nameMod){
        File modFile = new File("E:\\Simple-CRUD-java-app\\Mods\\zipFiles\\" + nameMod + ".zip");
        Resource resource = new FileSystemResource(modFile);
        String contentType = "application/zip";
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + modFile.getName() + "\"")
                .body(resource);
    }
}
