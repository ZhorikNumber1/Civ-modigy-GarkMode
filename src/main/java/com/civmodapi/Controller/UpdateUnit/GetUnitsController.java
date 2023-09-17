package com.civmodapi.Controller.UpdateUnit;

import com.civmodapi.DTOs.UnitsDTO;
import com.civmodapi.Model.UnitsCivilian;
import com.civmodapi.DTOs.UnitsCvilianDTO;
import com.civmodapi.Repository.UnitsRepository;
import com.civmodapi.Service.UnitsService.GetAllUnits;
import com.civmodapi.Service.UnitsService.GetSpecificUnit;
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
    @Autowired
    private GetSpecificUnit getSpecificUnit;
    @Autowired
    private GetAllUnits getAllUnits;

    @GetMapping("/units")
    public List<UnitsDTO> getData() throws IOException {
        return getAllUnits.getAllUnits();
    }

    @GetMapping("/units/{name}")
    public UnitsCvilianDTO getUnitsByName(@PathVariable String name) throws IOException {
        return getSpecificUnit.getUnit(name);
    }
}
