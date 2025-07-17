package com.example.demo.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("minioUploadStrategy")
public class MinioUploadStrategy implements UploadStrategy {
    @Override
    public String upload(MultipartFile file) throws Exception {
        // 这里应实现MinIO上传逻辑
        // 伪代码：minioClient.putObject(...);
        return file.getOriginalFilename() + "（已上传到MinIO）";
    }

    @Override
    public byte[] download(String filename) throws Exception {
        // 这里应实现MinIO下载逻辑
        // 伪代码：InputStream in = minioClient.getObject(...);
        // return in.readAllBytes();
        return null; // 伪实现
    }
}
