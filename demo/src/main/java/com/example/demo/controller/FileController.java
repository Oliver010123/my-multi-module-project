package com.example.demo.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class FileController {

    private static final String UPLOAD_DIR = "uploads";

    // 文件上传
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        File dir = new File(UPLOAD_DIR);
        if (!dir.exists()) dir.mkdirs();
        Path path = Paths.get(UPLOAD_DIR, file.getOriginalFilename());
        file.transferTo(path);
        return "上传成功: " + file.getOriginalFilename();
    }

    // 文件下载
    @GetMapping("/download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable String filename) throws IOException {
        Path path = Paths.get(UPLOAD_DIR, filename);
        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        }
        byte[] data = Files.readAllBytes(path);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }

    // 文件上传页面
    @GetMapping("/uploadPage")
    public String uploadPage() {
        return "<html>" +
                "<body>" +
                "<h2>文件上传</h2>" +
                "<form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">" +
                "<input type=\"file\" name=\"file\"/>" +
                "<button type=\"submit\">上传</button>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
