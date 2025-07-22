// File: FileUploadValidationAspect.java
package com.example.demo.aspect;

import java.io.IOException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;

// 文件上传校验切面，负责在文件上传接口执行前进行参数校验
@Aspect
@Component
public class FileUploadValidationAspect {

    // 最大文件大小限制为10MB
    private static final long MAX_FILE_SIZE = 10 * 1024 * 1024; // 10MB

    // 在FileController的upload方法执行前进行校验
    @Before("execution(* com.example.demo.controller.FileController.upload(..)) && args(file,..)")
    public void validateFile(JoinPoint joinPoint, MultipartFile file) {
        // 校验文件是否为空
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("文件不能为空");
        }
        // 校验文件大小
        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("文件大小不能超过10MB");
        }
        try {
            // 校验文件是否为图片类型
            if (ImageIO.read(file.getInputStream()) == null) {
                throw new IllegalArgumentException("上传的文件不是有效的图片文件");
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("文件读取失败");
        }
    }
}
