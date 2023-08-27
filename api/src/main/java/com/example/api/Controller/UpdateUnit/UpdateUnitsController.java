package com.example.api.Controller.UpdateUnit;

import com.example.api.Model.Mods_units;
import com.example.api.Model.Units_civilian;
import com.example.api.Repository.mod_unitsRepository;
import com.example.api.Repository.unitsRepository;
import com.example.api.Service.mod_textService;
import com.example.api.Service.user_modService;
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
public class UpdateUnitsController {
    @Autowired
    private unitsRepository unitsRepository;
    @Autowired
    private mod_unitsRepository mod_unitsRepository;
    @PostMapping(path = "/create_mod")
    public String create_mod(@RequestBody Mods_units unit_Update) throws IOException {
        Optional<Units_civilian> exsting_Unit = unitsRepository.findById(unit_Update.getId());
        mod_unitsRepository.save(unit_Update);
        user_modService.createModFolder(unit_Update.getNameMod());
        String folderPath = "E:\\Simple-CRUD-java-app\\api\\Mods\\" + unit_Update.getNameMod();

        user_modService.addTexttoModInfoFile(mod_textService.modInfoFile_text(unit_Update), "E:\\Simple-CRUD-java-app\\api\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getNameMod() + ".modinfo");
        user_modService.addTexttoModInfoFile(mod_textService.xmlDBFile_inGameActions(unit_Update, exsting_Unit), "E:\\Simple-CRUD-java-app\\api\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getName() + unit_Update.getNameMod() + ".xml");
        user_modService.archiveFolder(folderPath);
        String modInfoFile = mod_textService.modInfoFile_text(unit_Update);
        return unit_Update.getNameMod();
    }
    @GetMapping("/downloadMod/{nameMod}")
    public ResponseEntity<Resource> downloadMod(@PathVariable String nameMod){
        File modFile = new File("E:\\Simple-CRUD-java-app\\api\\Mods\\zipFiles\\" + nameMod + ".zip");
        Resource resource = new FileSystemResource(modFile);
        String contentType = "application/zip";
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + modFile.getName() + "\"")
                .body(resource);
    }
}
