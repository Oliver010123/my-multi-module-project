// File: FileUploadValidationAspect.java
package com.example.demo.aspect;

import java.io.IOException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

@Aspect
@Component
public class FileUploadValidationAspect {

    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

    @Before("execution(* com.example.demo.controller.FileController.upload(..)) && args(file,..)")
    public void validateFile(JoinPoint joinPoint, MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("文件大小不能超过10MB");
        }
        try {
            if (ImageIO.read(file.getInputStream()) == null) {
                throw new IllegalArgumentException("上传的文件不是有效的图片文件");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("上传的文件不是有效的图片文件");
        }
    }
}
