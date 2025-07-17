package com.example.demo.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("fastdfsUploadStrategy")
public class FastdfsUploadStrategy implements UploadStrategy {
    @Override
    public String upload(MultipartFile file) throws Exception {
        // 这里应实现FastDFS上传逻辑
        // 伪代码：fastdfsClient.upload(file.getInputStream(), file.getOriginalFilename());
        return file.getOriginalFilename() + "（已上传到FastDFS）";
    }

    @Override
    public byte[] download(String filename) throws Exception {
        // 这里应实现FastDFS下载逻辑
        // 伪代码：return fastdfsClient.download(filename);
        return null; // 伪实现
    }
}
