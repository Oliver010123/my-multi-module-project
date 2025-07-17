package com.example.demo.upload;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component("ftpUploadStrategy")
public class FtpUploadStrategy implements UploadStrategy {
    @Override
    public String upload(MultipartFile file) throws Exception {
        // 这里应实现FTP上传逻辑
        // 伪代码：ftpClient.storeFile(file.getOriginalFilename(), file.getInputStream());
        return file.getOriginalFilename() + "（已上传到FTP）";
    }

    @Override
    public byte[] download(String filename) throws Exception {
        // 这里应实现FTP下载逻辑
        // 伪代码：ByteArrayOutputStream out = new ByteArrayOutputStream();
        // ftpClient.retrieveFile(filename, out);
        // return out.toByteArray();
        return null; // 伪实现
    }
}
