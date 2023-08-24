package com.example.api;

import com.example.api.Controller.UpdateUnit.GetUnitsController;
import com.example.api.Model.Units_civilian;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.example.api.Repository.unitsRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(GetUnitsController.class)
public class YourControllerTest {

    @InjectMocks
    private GetUnitsController yourController;

    @Mock
    private unitsRepository unitsRepository;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(yourController).build();
    }

    @Test
    public void testGetData() throws Exception {
        // Mock units data
        Units_civilian unit1 = new Units_civilian("Unit 1", "photo1.jpg", "Type 1");
        Units_civilian unit2 = new Units_civilian("Unit 2", "photo2.jpg", "Type 2");
        when(unitsRepository.findAll()).thenReturn(Arrays.asList(unit1, unit2));

        // Mock file and file path
        String photoDirectory = "E:\\Simple-CRUD-java-app\\api\\src\\main\\java\\com\\example\\api\\Img\\";
        byte[] photoData = new byte[]{1, 2, 3};
        MockMultipartFile mockMultipartFile = new MockMultipartFile("photo", "photo1.jpg", MediaType.IMAGE_JPEG_VALUE, photoData);
        String photoFilePath = photoDirectory + unit1.getNamePhoto();
        Path photoPath = Paths.get(photoFilePath);
        Files.createDirectories(photoPath.getParent());
        Files.write(photoPath, photoData);

        // Perform the GET request for "/units"
        mockMvc.perform(MockMvcRequestBuilders.get("/units"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value(unit1.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].urlPhoto").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].unitType").value(unit1.getUnitType()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].name").value(unit2.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].urlPhoto").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].unitType").value(unit2.getUnitType()));

        // Cleanup the test directory
        Files.delete(photoPath);
        Files.delete(photoPath.getParent());
    }
}