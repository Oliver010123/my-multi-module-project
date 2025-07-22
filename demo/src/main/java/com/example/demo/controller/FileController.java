package com.example.demo.controller;

import com.example.demo.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
//import java.io.ByteArrayInputStream;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    // 文件上传

        // java
        @PostMapping("/upload")
        @ResponseBody
        public String upload(@RequestParam("file") MultipartFile file) throws Exception {
            String filename = fileService.upload(file);
            return "上传成功: " + filename;
        }
//            直接请求
//            @PostMapping("/upload")
//            public String upload(@RequestParam("file") MultipartFile file) throws Exception {
//            BufferedImage image = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
//            if (image == null) {
//                throw new IllegalArgumentException("上传的文件不是有效的图片文件");
//            }
//            else{
//                String filename = fileService.upload(file);
//                return "上传成功: " + filename;}
    // 文件下载
    @GetMapping("/download/{filename}")
    @ResponseBody
    public ResponseEntity<byte[]> download(@PathVariable String filename) throws Exception {// ResponseEntity<byte[]> 用于返回文件的字节数组
        byte[] data = fileService.download(filename);
        if (data == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(data);
    }
    // 文件上传页面
    @GetMapping("/uploadPage")
    public ModelAndView uploadPage() {
        return new ModelAndView("uploadPage");
    }
}
//    // 文件上传页面
//    @GetMapping("/uploadPage")
//    public String uploadPage() {
//        return "<html>" +
//                "<body>" +
//                "<h2>文件上传</h2>" +
//                "<form action=\"/upload\" method=\"post\" enctype=\"multipart/form-data\">" +
//                "<input type=\"file\" name=\"file\"/>" +
//                "<button type=\"submit\">上传</button>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }
//}
