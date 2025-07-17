package com.example.demo.upload;

import org.springframework.web.multipart.MultipartFile;

public interface UploadStrategy {
    String upload(MultipartFile file) throws Exception;
    byte[] download(String filename) throws Exception;
}
