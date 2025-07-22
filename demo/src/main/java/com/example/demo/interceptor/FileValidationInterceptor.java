/*
package com.example.demo.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Set;

@Component
public class FileValidationInterceptor implements HandlerInterceptor {//拦截器

    private static final Set<String> ALLOWED_TYPES = Set.of(
            "image/jpeg", "image/png", "image/gif"
    );// 支持的图片类型

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getRequestURI().equals("/upload")) {
            return true;
        }

        if (!(request instanceof MultipartHttpServletRequest)) {
            sendError(response, 400, "请上传文件");
            return false;
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("file");

        if (file == null || file.isEmpty()) {
            sendError(response, 400, "文件不能为空");
            return false;
        }


        if (!ALLOWED_TYPES.contains(file.getContentType())) {
            sendError(response, 400, "只支持JPEG、PNG和GIF图片");
            return false;
        }

        try {
            byte[] bytes = file.getBytes();
            BufferedImage image = ImageIO.read(new ByteArrayInputStream(bytes));
            if (image == null) {
                sendError(response, 400, "上传的文件不是有效的图片文件");
                return false;
            }
        } catch (IOException e) {
            sendError(response, 500, "文件读取失败");
            return false;
        }

        return true;
    }

    private void sendError(HttpServletResponse response, int code, String message) throws IOException {
        response.setStatus(code);
        response.setContentType("application/json");
        response.getWriter().write("{\"error\": \"" + message + "\"}");// JSON格式的错误响应
    }
}
*/
