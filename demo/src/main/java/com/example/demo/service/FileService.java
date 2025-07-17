package com.example.demo.service;

import com.example.demo.upload.UploadStrategyContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileService {
    @Autowired
    private UploadStrategyContext uploadStrategyContext;

    public String upload(MultipartFile file) throws Exception {
        return uploadStrategyContext.getStrategy().upload(file);
    }

    // 这里只实现本地下载，其他方式可扩展
    public byte[] download(String filename) throws Exception {
        Path path = Paths.get("uploads", filename);
        if (!Files.exists(path)) {
            return null;
        }
        return Files.readAllBytes(path);
    }
}