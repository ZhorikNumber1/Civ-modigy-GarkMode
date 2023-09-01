package com.civmodapi.Service;

import org.apache.commons.compress.archivers.zip.ZipArchiveEntry;
import org.apache.commons.compress.archivers.zip.ZipArchiveOutputStream;
import org.apache.commons.compress.utils.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public interface UserModService {
    static void createModFolder(String nameMod) throws IOException {

        String path_to_directory = "E:\\Simple-CRUD-java-app\\Mods\\" + nameMod;
        File folder = new File(path_to_directory);

        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    static void archiveFolder(String folderPath) throws IOException {

        File folder = new File(folderPath);
        String zipFilePath = folderPath + ".zip";

        try (ZipArchiveOutputStream zipOut = new ZipArchiveOutputStream(new FileOutputStream(zipFilePath))) {
            addFileToZip(folder, folder.getName(), zipOut);
        }
    }

    private static void addFileToZip(File file, String fileName, ZipArchiveOutputStream zipOut) throws IOException {
        ZipArchiveEntry entry = new ZipArchiveEntry(file, fileName);
        zipOut.putArchiveEntry(entry);

        if (file.isFile()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                IOUtils.copy(fis, zipOut);
                zipOut.closeArchiveEntry();
            }
        } else if (file.isDirectory()) {
            zipOut.closeArchiveEntry();

            for (File nestedFile : file.listFiles()) {
                addFileToZip(nestedFile, fileName + "/" + nestedFile.getName(), zipOut);
            }
        }
    }

    static void addTextToModInfoFile(String text, String filepath) {
        FileSystemResource resource = new FileSystemResource(filepath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(resource.getFile(), false))) {
            writer.write(text);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
