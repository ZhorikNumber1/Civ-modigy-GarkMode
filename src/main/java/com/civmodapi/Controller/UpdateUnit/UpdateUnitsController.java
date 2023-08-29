package com.civmodapi.Controller.UpdateUnit;

import com.civmodapi.Model.Mods_units;
import com.civmodapi.Model.Units_civilian;
import com.civmodapi.Repository.unitsRepository;
import com.civmodapi.Repository.mod_unitsRepository;
import com.civmodapi.Service.mod_textService;
import com.civmodapi.Service.user_modService;
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
        String folderPath = "E:\\CivModAPI\\Mods\\" + unit_Update.getNameMod();

        user_modService.addTextToModInfoFile(mod_textService.modInfoFile_text(unit_Update), "E:\\CivModAPI\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getNameMod() + ".modinfo");
        user_modService.addTextToModInfoFile(mod_textService.xmlDBFile_inGameActions(unit_Update, exsting_Unit), "E:\\CivModAPI\\Mods\\" + unit_Update.getNameMod() + "\\" + unit_Update.getName() + unit_Update.getNameMod() + ".xml");
        user_modService.archiveFolder(folderPath);
        String modInfoFile = mod_textService.modInfoFile_text(unit_Update);

        return unit_Update.getNameMod();
    }
    @GetMapping("/downloadMod/{nameMod}")
    public ResponseEntity<Resource> downloadMod(@PathVariable String nameMod){
        File modFile = new File("E:\\CivModAPI\\Mods\\zipFiles\\" + nameMod + ".zip");
        Resource resource = new FileSystemResource(modFile);
        String contentType = "application/zip";
        return ResponseEntity.ok().
                contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\"" + modFile.getName() + "\"")
                .body(resource);
    }
}
