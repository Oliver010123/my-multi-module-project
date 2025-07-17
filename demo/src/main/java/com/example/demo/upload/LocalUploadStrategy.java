package com.example.demo.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component("localUploadStrategy")
public class LocalUploadStrategy implements UploadStrategy {
    private static final String UPLOAD_DIR = "uploads";

    @Override
    public String upload(MultipartFile file) throws Exception {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) dir.mkdirs();
        Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        file.transferTo(path);
        return file.getOriginalFilename();
    }

    @Override
    public byte[] download(String filename) throws Exception {
        Path path = Paths.get(UPLOAD_DIR, filename);
        if (!Files.exists(path)) {
            return null;
        }
        return Files.readAllBytes(path);
    }
}
