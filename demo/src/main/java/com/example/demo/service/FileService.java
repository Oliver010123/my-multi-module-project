package com.example.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {

    private static final String UPLOAD_DIR = "uploads";

    public String upload(MultipartFile file) throws IOException {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) dir.mkdirs();
        Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        file.transferTo(path);
        return file.getOriginalFilename();
    }

    public byte[] download(String filename) throws IOException {
        Path path = Paths.get(UPLOAD_DIR, filename);
        if (!Files.exists(path)) {
            return null;
        }
        return Files.readAllBytes(path);
    }
}